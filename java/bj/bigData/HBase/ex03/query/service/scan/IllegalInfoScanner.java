package bj.bigData.HBase.ex03.query.service.scan;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.common.utils.ByteUtils;
import com.boco.DataPlatform.hbase.query.bean.*;
import com.boco.DataPlatform.hbase.query.endpoint.CdrCoprocessor;
import com.boco.DataPlatform.hbase.query.endpoint.ICoprocessor;
import com.boco.DataPlatform.hbase.query.exception.ClientParameterException;
import com.boco.DataPlatform.hbase.query.service.common.CurrentPage;
import com.boco.DataPlatform.hbase.query.service.common.IdcTableInfos;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore.Session;
import com.boco.DataPlatform.hbase.query.service.common.TCommonCondition;
import com.boco.DataPlatform.hbase.query.thrift.Filter;
import com.boco.DataPlatform.hbase.query.thrift.MainCondition;
import com.boco.DataPlatform.hbase.query.type.OperatorType;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.*;

public class IllegalInfoScanner extends BaseScanner implements Runnable {

	Logger logger = Logger.getLogger( IllegalInfoScanner.class );
	private static final TableInfo tableInfo  = IdcTableInfos.getTableInfo( TableConstants.TO_NET_ODS_ILLEGALINFO );
	//key length
	private static final int       KEY_LENGTH = TableConstants.TABLE_ILLEGALINFO_KEY_LENGTH;
	private int pageNo;
	private int pageSize;
	private Session       session     = null;
	private MainCondition condition   = null;
	private ICoprocessor  coprocessor = null;
	private String baseTable;
	
	// 查询条件
	private Date                  start;
	private Date                  end;
	private Map< String, Filter > filters;
	// 是否只查询当前数据，数据导出时设置为false
	private boolean limited             = true;
	// 查询条件-机房ID-必填
	private String  REQUIRED_HOUSE_ID   = "HOUSE_ID";
	// 查询条件-服务IP-必填
	private String  REQUIRED_SERVICE_IP = "SERVICE_IP";
	//在结果中包含 时间字段
	private String  RESULT_FOUND_TIME   = "FOUND_TIME";
	
	
	public IllegalInfoScanner( Session session, TCommonCondition tcc,
	                           MainCondition condition, String baseTable, HTablePool pool,
	                           Configuration conf ) {

		super( conf );
		this.condition = condition;
		this.session = session;
		this.pageNo = tcc.getPageNo();
		this.pageSize = tcc.getPageSize();
		this.baseTable = baseTable;
		this.coprocessor = new CdrCoprocessor( pool );
		Thread.currentThread().setName(
				String.format( "TH%06d", session.getSid() ) );
	}

	@Override
	public void run() {

		logger.info( "Query Thread:" + session.getSid() + ",pageNo:" + pageNo
		             + ",pageSize:" + pageSize + " started..." );
		if ( null == session ) {
			logger.error( "Empty Session" );
			return;
		}
		try {
			checkCondition( condition );
		} catch ( ClientParameterException e1 ) {
			logger.error( e1.getMessage() );
			session.setErrorcode( 1 );
			session.setErrormsg( e1.getMessage() );
			session.notifyMe();
			return;
		}

		CurrentPage page = session.getPage();
		QueryResult qr   = new QueryResult();
		// 组装table
		Set< String > tables = buildTables( start, end );
		if ( tables.size() == 0 ) {
			logger.info( "hbase table not exists for this time range[" + start
			             + "-" + end + "]" );
			return;
		}
		Scan scan = createScan();
		
		int rssize = 0;
		for ( String table : tables ) {
			logger.info( "start query table:" + table + "..." );
			// 查询
			QueryResult nr;
			try {
//				HTable htable = new HTable(conf, table);
//				ResultScanner rs = htable.getScanner(scan);
//				System.out.println("-------------------");
//				for (Result r : rs) {
//					System.out.println(new String(r.getRow()));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("c"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("d"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("e"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("f"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("g"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("h"))));
//					System.out.println(new String(r.getValue(Bytes.toBytes("f"), Bytes.toBytes("i"))));
//					System.out.println("-------------------");
//				}
				nr = coprocessor.query( table.getBytes(), scan );
				//当查询成功 并查到数据
				if ( nr != null && nr.getResult().size() > 0 ) {
					for ( QueryRow qrow : nr.getResult() ) {
						//添加结果行
						qr.addData( qrow );
					}
					rssize += nr.getResult().size();
					// 当数据足够后，不再查询后面的表
					if ( limited && rssize >= page.getNeeds() ) {
						break;
					}
				}
			} catch ( Throwable e ) {
				e.printStackTrace();
			}
		}
		buildRestut( tableInfo, page, qr );
		session.notifyMe();
	}

	/**
	 * 检查客户端输入条件是否合法，检查客户端输入条件是否合法，主要进行两类检查 1.时间格式是否正确（yyyy-MM-dd HH:mm:ss）
	 * 2.必须输入的条件是否为空
	 *
	 * @param condition
	 * @throws ClientParameterException
	 */
	private void checkCondition( MainCondition condition )
			throws ClientParameterException {

		try {
			start = formatDate( condition.getStarttime() );
		} catch ( ParseException e ) {
			throw new ClientParameterException(
					"Error Client Parameter[start time],must [yyyy-MM-dd HH:mm:ss]." );
		}
		try {
			end = formatDate( condition.getEndtime() );
		} catch ( ParseException e ) {
			throw new ClientParameterException(
					"Error Client Parameter[end time],must [yyyy-MM-dd HH:mm:ss]." );
		}
		//houseid 和  destip 都是必填项
		filters = getClientFilter( condition );
		//检查 houseid
		if ( !filters.containsKey( REQUIRED_HOUSE_ID ) ) {
			throw new ClientParameterException(
					"Error Client Parameter[HOUSE_ID],must required." );
		}
		//检查 destip
		if ( !filters.containsKey( REQUIRED_SERVICE_IP ) ) {
			throw new ClientParameterException(
					"Error Client Parameter[DEST_IP],must required." );
		}
	}
	
	/**
	 * 因为数据按天建表 查询可能跨天，因此需要获取该时间段内所有的表 时间跨度为 一天
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	private Set< String > buildTables( Date start, Date end ) {

		Set< String > tables = new LinkedHashSet< String >();
		// 一天的毫秒数
		long dayms  = 1 * 24 * 60 * 60 * 1000;
		long dstart = start.getTime();
		long dend   = end.getTime();
		do {
			String tableName = getTable( baseTable,
					ConvertUtils.longToYMDString( dstart ) );
			try {
				if ( checkTable( tableName ) ) {
					tables.add( tableName );
				} else {
					logger.error( "table not Exists:" + tableName );
				}
			} catch ( Exception e ) {
			}
			dstart += dayms;
		} while ( dstart < dend );
		String tableName = getTable( baseTable,
				ConvertUtils.longToYMDString( dend ) );
		try {
			if ( checkTable( tableName ) ) {
				tables.add( tableName );
			} else {
				logger.error( "table not Exists:" + tableName );
			}
		} catch ( Exception e ) {
			//
		}
		return tables;
	}
	
	
	/**
	 * 构建 scan对象
	 *
	 * @return
	 */
	private Scan createScan() {

		Scan scan = new Scan();
		scan.addFamily( TableConstants.COMMON_COLUMN_FAMILY );
		// 添加最大查询数量
		scan.setAttribute( TableConstants.LIMIT_FLAG, ( pageSize + "" ).getBytes() );

		byte[] startKey = ByteUtils.createArray( KEY_LENGTH, ( byte ) 0 );
		byte[] endKey   = ByteUtils.createArray( KEY_LENGTH, ( byte ) Byte.MAX_VALUE );

		StringBuilder valuefilter = new StringBuilder();
		StringBuilder keyfilter   = new StringBuilder();
		
		//valuefilter 的首条标记
		//valuefilter 插入一条后置为false  用于插入分割标记
		boolean first = true;
		//遍历过滤条件  添加到scan中 用于查询
		for ( Map.Entry< String, Filter > set : filters.entrySet() ) {
			String field  = set.getKey();
			Filter filter = set.getValue();
			// 在前面添加分割标记 首条除外
			if ( !first ) {
				valuefilter.append( TableConstants.FILTERS_MUTIL_SPLITER );
			}
			// 基于houseId的过滤
			if ( field.equals( REQUIRED_HOUSE_ID ) ) {
				byte[] houseIdCode = getHouseIdCode( filter.getValue() );
				System.arraycopy( houseIdCode, 0, startKey, 0, 6 );
				System.arraycopy( houseIdCode, 0, endKey, 0, 6 );
				valuefilter.append( tableInfo.getValueFilterStr( REQUIRED_HOUSE_ID,
						OperatorType.EQ, filters.get( REQUIRED_HOUSE_ID ).getValue() ) );
				//valueFilter中添加了一条数据后 first置为 false
				first = false;
			} else { //其他过滤条件 直接加入到 valuefilter中
				//得到与 MatchType 对应的Operatortype
				OperatorType type = getOperatorType( filter.getMatchType().getValue() );
				valuefilter.append( tableInfo.getValueFilterStr( field, type, filter.getValue() ) );
				first = false;
			}
		}
		
		scan.setAttribute( TableConstants.VALUE_FILTERS_FLAG, valuefilter
				.toString().getBytes() );
		scan.setAttribute( TableConstants.KEY_FILTERS_FLAG, keyfilter.toString()
				.getBytes() );
		System.out.println( "START:" );
		printBytes( startKey );
		System.out.println( "END:" );
		printBytes( endKey );
		
		scan.setStartRow( startKey );
		scan.setStopRow( endKey );
		return scan;
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
	
	private void printBytes( byte[] bs ) {

		for ( byte b : bs ) {
			System.out.print( b + " " );
		}
		System.out.println();
	}
	
	/**
	 * 时间字段需要重新设置,重写此方法
	 */
	@Override
	protected List< String > getMetadata( TableInfo tableInfo ) {

		List< String > metadata = new ArrayList< String >();
		metadata.add( RESULT_FOUND_TIME );
		metadata.addAll( tableInfo.getMetadata() );
		return metadata;
	}
	
	/**
	 * 公共的数据获取方法,有特殊的情况时子类重写此方法
	 *
	 * @param tableInfo
	 * @return
	 */
	@Override
	//时间字段需要从key中获取
	protected void getResultString( List< String > r, List< ResultColumn > columns ) {

		for ( ResultColumn rc : columns ) {
			if ( Bytes.equals( rc.getQualifier(), TableConstants.COMMON_ROWKEY_FLAG ) ) {
				r.add( getDateFromKey( rc.getDatarow() ) );
			} else {
				String[] fields = new String( rc.getDatarow() ).split( "\\|", -1 );
				r.addAll( Arrays.asList( fields ) );
			}
		}
	}
	
	/**
	 * 从key中取出时间数据
	 *
	 * @param key
	 * @return
	 */
	private String getDateFromKey( byte[] key ) {

		byte[] linedate = new byte[ 14 ];
		// 在key中时间字段是从6位开始的14位byte
		System.arraycopy( key, 6, linedate, 0, 14 );
		return ConvertUtils.lineDateToSimpleDate( new String( linedate ) );
	}
}
