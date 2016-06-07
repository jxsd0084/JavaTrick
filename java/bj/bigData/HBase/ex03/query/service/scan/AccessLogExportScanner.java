package bj.bigData.HBase.ex03.query.service.scan;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.common.utils.ByteUtils;
import com.boco.DataPlatform.hbase.query.bean.*;
import com.boco.DataPlatform.hbase.query.endpoint.ICoprocessor;
import com.boco.DataPlatform.hbase.query.exception.ClientParameterException;
import com.boco.DataPlatform.hbase.query.service.common.IdcTableInfos;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore.Session;
import com.boco.DataPlatform.hbase.query.thrift.Filter;
import com.boco.DataPlatform.hbase.query.thrift.MainCondition;
import com.boco.DataPlatform.hbase.query.thrift.MatchType;
import com.boco.DataPlatform.hbase.query.type.OperatorType;
import com.boco.DataPlatform.hbase.writer.XMLExportResult;
import com.boco.DataPlatform.hbase.writer.XmlClient;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.*;

public class AccessLogExportScanner extends BaseScanner implements Runnable {

	private static final Logger    logger    = Logger
			.getLogger( AccessLogExportScanner.class );
	private static final TableInfo tableInfo = IdcTableInfos
			.getTableInfo( TableConstants.TO_NET_ODS_ACCESSLOGS );

	private static final int           KEY_LENGTH  = TableConstants.TABLE_ACCESSLOGS_KEY_LENGTH;
	private              MainCondition condition   = null;
	private              Session       session     = null;
	private              ICoprocessor  coprocessor = null;
	private String baseTable;

	private Date                  start;
	private Date                  end;
	private Map< String, Filter > filters;
	//查询条件-IDC_ID-必填
	private String REQUIRED_IDC_ID   = "IDC_ID";
	// 查询条件-机房ID-必填
	private String REQUIRED_HOUSE_ID = "HOUSE_ID";
	// 查询条件-目的IP-可选
	private String OPTIONAL_DEST_IP  = "DESTIP";
	// 查询条件-URL-可选

	private String OPTIONAL_URL = "URL";

	private String RESULT_ACCESS_TIME = "ACCESS_TIME";

	
	public AccessLogExportScanner( Session session,
	                               MainCondition condition, String baseTable, ICoprocessor coprocessor,
	                               Configuration conf ) {

		super( conf );
		this.condition = condition;
		this.session = session;
		this.baseTable = baseTable;
		this.coprocessor = coprocessor;
		Thread.currentThread().setName(
				String.format( "TH%06d", session.getSid() ) );
	}

	@Override
	public void run() {

		filters = getClientFilter( condition );
		logger.info( "Query Thread:" + session.getSid() + "started..." );
		String          commandId = condition.getAttributes().get( "commandId" );
		String          idc_id    = filters.get( REQUIRED_IDC_ID ).getValue();
		XMLExportResult rs        = new XMLExportResult( commandId, idc_id );
		// 检查参数是否合法
		try {
			checkCondition( condition );
		} catch ( ClientParameterException e1 ) {
			logger.error( e1.getMessage() );
			rs.setSucceed( false );
			XmlClient.ResultToXml( rs );
			return;
		}
		// 组装table
		Set< String > tables = buildTables( start, end );
		if ( tables.size() == 0 ) {
			// session.setErrorcode(2);
			// session.setErrormsg("hbase table not exists for this time range["
			// + start + "-" + end + "]");
			logger.info( "hbase table not exists for this time range[" + start
			             + "-" + end + "]" );
			rs.setSucceed( false );
			XmlClient.ResultToXml( rs );
			return;
		}
		// scan
		Scan scan = createScan();
		rs.setMetadata( getMetadata( tableInfo ) );
		for ( String table : tables ) {
			logger.info( "start query table:" + table + "..." );
			// 查询
			QueryResult nr;
			try {
				nr = coprocessor.query( table.getBytes(), scan );
				if ( nr != null && nr.getResult().size() > 0 ) {
					for ( QueryRow qrow : nr.getResult() ) {
						List< String >       r       = new ArrayList< String >();
						List< ResultColumn > columns = qrow.getColumns();
						getResultString( r, columns );
						rs.addData( r );
					}
				}
			} catch ( Throwable e ) {
				e.printStackTrace();
			}
		}
		XmlClient.ResultToXml( rs );
		session.notifyMe();
	}

	// 创建查询Scan对象
	private Scan createScan() {

		Scan scan = new Scan();
		scan.addFamily( TableConstants.COMMON_COLUMN_FAMILY );
		// 添加最大查询数量
		scan.setAttribute( TableConstants.LIMIT_FLAG, Bytes.toBytes( "-1" ) );

		StringBuilder valuefilter = new StringBuilder();
		StringBuilder keyfilter   = new StringBuilder();

		byte[] startKey = ByteUtils.createArray( KEY_LENGTH, ( byte ) 0 );
		byte[] endKey   = ByteUtils.createArray( KEY_LENGTH, Byte.MAX_VALUE );
		// 基于houseId的过滤
		byte[] houseIdCode = getHouseIdCode( filters.get( REQUIRED_HOUSE_ID )
				.getValue() );
		System.arraycopy( houseIdCode, 0, startKey, 0, 6 );
		System.arraycopy( houseIdCode, 0, endKey, 0, 6 );
		valuefilter.append( tableInfo.getValueFilterStr( REQUIRED_HOUSE_ID,
				OperatorType.EQ, filters.get( REQUIRED_HOUSE_ID ).getValue() ) );

		// 基于DESC IP的过滤
		if ( filters.containsKey( OPTIONAL_DEST_IP ) ) {
			valuefilter.append( TableConstants.FILTERS_MUTIL_SPLITER );
			Filter filter = filters.get( OPTIONAL_DEST_IP );
			// 精确IP查询
			if ( filter.getMatchType() == MatchType.EQUAL ) {
				byte[] descIpCode = getDescIPCode( filter.getValue() );
				System.arraycopy( descIpCode, 0, startKey, 6, 8 );
				System.arraycopy( descIpCode, 0, endKey, 6, 8 );
				valuefilter.append( tableInfo.getValueFilterStr(
						OPTIONAL_DEST_IP, OperatorType.EQ, filter.getValue() ) );

				// 时间
				byte[] bstart = ConvertUtils.convertDateToFullString( start )
						.getBytes();
				byte[] bend = ConvertUtils.convertDateToFullString( end )
						.getBytes();
				System.arraycopy( bstart, 0, startKey, 14, 14 );
				System.arraycopy( bend, 0, endKey, 14, 14 );
			} else {
				valuefilter.append( tableInfo.getValueFilterStr(
						OPTIONAL_DEST_IP, getOperatorType( filter.getMatchType().getValue() ),
						filter.getValue() ) );

				String linestart = ConvertUtils.convertDateToFullString( start );
				String lineend   = ConvertUtils.convertDateToFullString( end );
				String timefilter = "14" + TableConstants.FILTER_SPLITER + "14"
				                    + TableConstants.FILTER_SPLITER + "DATERANGE"
				                    + TableConstants.FILTER_SPLITER + linestart + "," + lineend;
				keyfilter.append( timefilter );
			}
		} else {// 没有IP过滤
			String linestart = ConvertUtils.convertDateToFullString( start );
			String lineend   = ConvertUtils.convertDateToFullString( end );
			String timefilter = "14" + TableConstants.FILTER_SPLITER + "14"
			                    + TableConstants.FILTER_SPLITER + "DATERANGE"
			                    + TableConstants.FILTER_SPLITER + linestart + "," + lineend;
			keyfilter.append( timefilter );
		}

		// URL
		if ( filters.containsKey( OPTIONAL_URL ) ) {
			Filter filter = filters.get( OPTIONAL_URL );
			valuefilter.append( TableConstants.FILTERS_MUTIL_SPLITER );
			valuefilter.append( tableInfo.getValueFilterStr( OPTIONAL_URL,
					OperatorType.LIKE, filter.getValue() ) );
		}
		// 如果有其他的过滤，在此处添加
		//遍历过滤条件  添加到scan中 用于查询
		for ( Map.Entry< String, Filter > set : filters.entrySet() ) {

			String field = set.getKey();
			if ( field.equals( OPTIONAL_DEST_IP ) || field.equals( REQUIRED_HOUSE_ID ) ||
			     field.equals( OPTIONAL_URL ) ) {
				continue;
			}
			Filter filter = set.getValue();
			// 在前面添加分割标记 
			valuefilter.append( TableConstants.FILTERS_MUTIL_SPLITER );
			OperatorType type = getOperatorType( filter.getMatchType().getValue() );
			valuefilter.append( tableInfo.getValueFilterStr( field, type, filter.getValue() ) );
		}

		scan.setAttribute( TableConstants.VALUE_FILTERS_FLAG, valuefilter
				.toString().getBytes() );
		scan.setAttribute( TableConstants.KEY_FILTERS_FLAG, keyfilter.toString()
				.getBytes() );

//		System.out.println(valuefilter.toString());
//		System.out.println(keyfilter.toString());
//
//		System.out.println("START:");
//		printBytes(startKey);
//		System.out.println("END:");
//		printBytes(endKey); 
		scan.setStartRow( startKey );
		scan.setStopRow( endKey );
		return scan;
	}

//	private void printBytes(byte[] bs){
//		for(byte b:bs){
//			System.out.print(b+" ");
//		}
//		System.out.println();
//	}

	/**
	 * 如果有字段需要转码，调用此程序
	 *
	 * @param list
	 * @param base
	 * @return
	 */
	@SuppressWarnings( "unused" )
	private List< String > decode( List< String > list, String[] base ) {
		// TODO
		return list;
	}

	/**
	 * 因为数据按小时分表，查询可能跨小时，因此需要获取该时间段内所有的表 时间跨度为 一小时
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	protected Set< String > buildTables( Date start, Date end ) {

		Set< String > tables = new LinkedHashSet< String >();
		// 1小时的毫秒数
		long dayms  = 1 * 60 * 60 * 1000;
		long dstart = start.getTime();
		long dend   = end.getTime();
		do {
			String tableName = getTable( baseTable,
					ConvertUtils.longToYMDHString( dstart ) );
			// 检查Table是否存在
			try {
				if ( checkTable( tableName ) ) {
					tables.add( tableName );
				} else {
					logger.error( "table not Exists:" + tableName );
				}
			} catch ( Exception e ) {
			}
			dstart = dstart + dayms;
		} while ( dstart < dend );
		String tableName = getTable( baseTable,
				ConvertUtils.longToYMDHString( dend ) );
		try {
			if ( checkTable( tableName ) ) {
				tables.add( tableName );
			} else {
				logger.error( "table not Exists:" + tableName );
			}
		} catch ( Exception e ) {
		}
		return tables;
	}

	// 时间字段需要重新设置,重写此方法
	@Override
	protected List< String > getMetadata( TableInfo tableInfo ) {

		List< String > list = new ArrayList< String >();
		list.add( RESULT_ACCESS_TIME );
		list.addAll( tableInfo.getMetadata() );
		return list;
	}

	/**
	 * 公共的数据获取方法,有特殊的情况时子类重写此方法
	 *
	 * @param tableInfo
	 * @return
	 */
	@Override
	// 时间字段需要从key中获取
	protected void getResultString( List< String > r, List< ResultColumn > columns ) {

		for ( ResultColumn rc : columns ) {
			if ( Bytes.equals( rc.getQualifier(),
					TableConstants.COMMON_ROWKEY_FLAG ) ) {
				r.add( getDateFromKey( rc.getDatarow() ) );
			} else {
				String[] fields = new String( rc.getDatarow() ).split( "\\|", -1 );
				for ( String s : fields ) {
					r.add( s );
				}
			}
		}
	}

	private String getDateFromKey( byte[] key ) {

		byte[] linedate = new byte[ 14 ];
		// 在key中时间字段是从14位开始的14位byte
		System.arraycopy( key, 14, linedate, 0, 14 );
		return ConvertUtils.lineDateToSimpleDate( new String( linedate ) );
	}
	
	/**
	 * 检查客户端输入条件是否合法，主要进行两类检查 1.时间格式是否正确（yyyy-MM-dd HH:mm:ss） 2.必须输入的条件是否为空
	 *
	 * @param condition
	 * @return
	 */
	private void checkCondition( MainCondition condition )
			throws ClientParameterException {

		try {
			start = formatDate( condition.starttime );
		} catch ( ParseException e ) {
			throw new ClientParameterException(
					"Error Client Parameter[start time],must [yyyy-MM-dd HH:mm:ss]." );
		}
		try {
			end = formatDate( condition.endtime );
		} catch ( ParseException e ) {
			throw new ClientParameterException(
					"Error Client Parameter[end time],must [yyyy-MM-dd HH:mm:ss]." );
		}
		filters = getClientFilter( condition );
		if ( !filters.containsKey( REQUIRED_IDC_ID ) ) {
			throw new ClientParameterException(
					"Error Client Parameter[IDC_ID],must required." );
		}
		if ( !filters.containsKey( REQUIRED_HOUSE_ID ) ) {
			throw new ClientParameterException(
					"Error Client Parameter[HOUSE_ID],must required." );
		}
	}

	/**
	 * 得到相应的 operatorType 枚举类型
	 *
	 * @param val
	 * @return
	 */
	private OperatorType getOperatorType( int val ) {

		switch ( val ) {
			case 1:
				return OperatorType.EQ;
			case 2:
				return OperatorType.LIKE;
			case 3:
				return OperatorType.IPLIKE;
			case 4:
				return OperatorType.IPRANGE;
			default:
				return null;
		}
	}
}
