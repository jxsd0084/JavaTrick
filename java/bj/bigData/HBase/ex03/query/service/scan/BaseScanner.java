package bj.bigData.HBase.ex03.query.service.scan;

import com.boco.DataPlatform.hbase.common.utils.IDCUtils;
import com.boco.DataPlatform.hbase.query.bean.QueryResult;
import com.boco.DataPlatform.hbase.query.bean.QueryRow;
import com.boco.DataPlatform.hbase.query.bean.ResultColumn;
import com.boco.DataPlatform.hbase.query.bean.TableInfo;
import com.boco.DataPlatform.hbase.query.service.common.CurrentPage;
import com.boco.DataPlatform.hbase.query.thrift.Filter;
import com.boco.DataPlatform.hbase.query.thrift.MainCondition;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseScanner {

	private static final Logger           logger           = Logger.getLogger( BaseScanner.class );
	private static       SimpleDateFormat formatter        = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	private static final int              HOUSE_ID_LENGTH  = 6;
	private static final byte             DEFAULT_ID_DIELD = '0';
	protected Configuration conf;
	private   HBaseAdmin    admin;

	/**
	 * 构造函数，接收参数
	 *
	 * @param conf
	 */
	public BaseScanner( Configuration conf ) {

		this.conf = conf;
		try {
			admin = new HBaseAdmin( conf );
		} catch ( MasterNotRunningException e ) {
			e.printStackTrace();
		} catch ( ZooKeeperConnectionException e ) {
			e.printStackTrace();
		}
	}

	protected boolean checkTable( String table )
			throws IOException {

		if ( admin != null ) {
			return admin.tableExists( table );
		} else {
			return false;
		}
	}

	protected Map< String, Filter > getClientFilter( MainCondition condition ) {

		Map< String, Filter > map = new LinkedHashMap< String, Filter >();
		if ( condition.filters != null && condition.filters.size() > 0 ) {
			for ( Filter f : condition.filters ) {
				map.put( f.getField().toUpperCase(), f );
			}
		}
		return map;
	}

	protected Date formatDate( String d ) throws ParseException {

		return formatter.parse( d );
	}

	protected String getTable( String baseTable, String end ) {

		return baseTable.replace( "$ENDS$", end );
	}

	/**
	 * 因为hbase的key生成时对houseId进行了编码
	 * 因此在设置startkey和stopkey时需要进行相同的编码
	 *
	 * @return
	 */
	protected byte[] getHouseIdCode( String houseId ) {

		return IDCUtils.invers( IDCUtils.subRight( houseId.getBytes(), HOUSE_ID_LENGTH, DEFAULT_ID_DIELD ) );
	}

	/**
	 * 因为hbase的key生成时对houseId进行了编码
	 * 因此在设置startkey和stopkey时需要进行相同的编码
	 *
	 * @return
	 */
	protected byte[] getDescIPCode( String descip ) {

		return IDCUtils.stringHashToBytes( descip );
	}

	protected CurrentPage buildRestut( TableInfo tableInfo, CurrentPage page, QueryResult result ) {

		logger.info( "total size:" + result.getResult().size() + "..." );
		int totalsize = result.getResult().size();
		page.setResultsize( totalsize );
		int cusor = 0;
		int start = page.getStart();
		int end   = page.getStart() + page.getPageSize();
		page.setResultsize( totalsize );
		// 添加字段信息
		page.setMetadata( getMetadata( tableInfo ) );
		if ( totalsize > 0 && totalsize > start ) {
			ArrayList< List< String > > objrows = new ArrayList< List< String > >();
			for ( QueryRow row : result.getResult() ) {
				if ( cusor++ < start ) {
					continue;
				}
				if ( cusor > end ) {
					break;
				}
				List< String >       r       = new ArrayList< String >();
				List< ResultColumn > columns = row.getColumns();
				getResultString( r, columns );
				objrows.add( r );
			}
			page.setObjrows( objrows );
		}
		return page;
	}

	/**
	 * 公共的META获取方法,有特殊的情况时子类重写此方法
	 *
	 * @param tableInfo
	 * @return
	 */
	protected List< String > getMetadata( TableInfo tableInfo ) {

		return tableInfo.getMetadata();
	}

	/**
	 * 公共的数据获取方法,有特殊的情况时子类重写此方法
	 *
	 * @param tableInfo
	 * @return
	 */
	protected void getResultString( List< String > r, List< ResultColumn > columns ) {

		for ( ResultColumn rc : columns ) {
			String[] fields = new String( rc.getDatarow() ).split( "\\|", -1 );
			for ( String s : fields ) {
				r.add( s );
			}
		}
	}
}
