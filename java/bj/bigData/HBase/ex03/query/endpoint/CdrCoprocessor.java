package bj.bigData.HBase.ex03.query.endpoint;

import com.boco.DataPlatform.hbase.query.bean.QueryResult;
import com.boco.DataPlatform.hbase.query.endpoint.protocol.IQueryProtocol;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.Batch;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

/**
 * @author ranhualin
 * @date 2013-7-19
 */
public class CdrCoprocessor implements ICoprocessor {

	// 日志
	private static final Logger logger = Logger.getLogger( CdrCoprocessor.class );
	private HTablePool      pool;
	private HTableInterface table;
	
	static {
		PropertyConfigurator.configure( "conf/log4j.properties" );
	}

	public CdrCoprocessor( HTablePool pool ) {

		this.pool = pool;
	}
	
	public static void main( String[] args ) {
		
	}
	
	/**
	 * 查询汇总
	 */
	@Override
	public < R, S > QueryResult query( final byte[] tableName, final Scan scan )
			throws Throwable {

		validateParameters( scan );
		// 回调
		class QueryDataCallback implements Batch.Callback< QueryResult > {

			private QueryResult datalist        = new QueryResult();
			private int         scansize        = 0; // region数
			private int         complatedregion = 0; // 完成的region数
			private long        updateuucost    = 0;

			public QueryResult getDatas() {

				return datalist;
			}

			@Override
			public void update( byte[] region, byte[] row, QueryResult result ) {

				synchronized ( datalist ) {
					if ( result != null ) {
						logger.info( "a region scan completed:scan:"
						             + result.getScansize() );
						scansize = scansize + result.getScansize();
						complatedregion++;
						datalist.mergeData( result.getResult() );
					} else {
						logger.info( "ERRORRRR:result is null" );
					}
					logger.info( "total completed region: " + complatedregion
					             + " scan:" + scansize );
				}
			}
		}
		//回调
		QueryDataCallback callback = new QueryDataCallback();
		table = pool.getTable( tableName );
		table.coprocessorExec( IQueryProtocol.class, scan.getStartRow(),
				scan.getStopRow(),
				new Batch.Call< IQueryProtocol, QueryResult >() {

					@Override
					public QueryResult call( IQueryProtocol instance )
							throws IOException {
						// logger.info("rs update: true!!!");
						QueryResult d = instance.query( null, scan );
						return d;
					}
				}, callback );
		QueryResult db = callback.getDatas();
		table.close();
		return db;
	}

	public < R, S > Long count( final byte[] tableName, final Scan scan ) throws Throwable {

		validateParameters( scan );
		class QueryDataCallback implements Batch.Callback< Long > {

			int rcount = 0;
			private Long count = 0L;

			public Long getDatas() {

				return count;
			}

			public void update( byte[] region, byte[] row, Long result ) {

				logger.info( "complate region:" + ( rcount++ ) + ",Size:" + result );
				count = count + result;
			}
		}
		QueryDataCallback callback = new QueryDataCallback();
		table = pool.getTable( tableName );
		table.coprocessorExec( IQueryProtocol.class, scan.getStartRow(),
				scan.getStopRow(), new Batch.Call< IQueryProtocol, Long >() {
					@Override
					public Long call( IQueryProtocol arg0 ) throws IOException {

						return arg0.count( null, scan );
					}
				}, callback );
		table.close();
		return callback.getDatas();
	}

	/**
	 * 校验scan是否合法
	 *
	 * @param scan
	 * @throws IOException
	 */
	public void validateParameters( Scan scan ) throws IOException {

		if ( scan == null
		     || ( Bytes.equals( scan.getStartRow(), scan.getStopRow() ) && !Bytes
				.equals( scan.getStartRow(), HConstants.EMPTY_START_ROW ) )
		     || Bytes.compareTo( scan.getStartRow(), scan.getStopRow() ) > 0 ) {
			throw new IOException(
					"Agg client Exception: Startrow should be smaller than Stoprow" );
		} else if ( scan.getFamilyMap().size() != 1 ) {
			throw new IOException( "There must be only one family."
			                       + scan.getFamilyMap().size() );
		}
	}
}
