package bj.bigData.HBase.ex03.query.endpoint.protocol;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.bean.QueryResult;
import com.boco.DataPlatform.hbase.query.bean.QueryRow;
import com.boco.DataPlatform.hbase.query.filter.KeyPartFilter;
import com.boco.DataPlatform.hbase.query.filter.ValueFilter;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.BaseEndpointCoprocessor;
import org.apache.hadoop.hbase.coprocessor.ColumnInterpreter;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.regionserver.InternalScanner;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CdrProtocolImpl extends BaseEndpointCoprocessor implements
		IQueryProtocol {

	// 日志
	private static final Logger logger = Logger.getLogger( CdrProtocolImpl.class );
	private ValueFilter   valuefilters;
	private KeyPartFilter keyfilters;
	private int limit = -1;

	QueryResult data; // 查询结果类
	long nextcost = 0;
	int  scansize = 0; // 扫描了多少条数据

	public CdrProtocolImpl() {

		super();
	}

	/**
	 * 查询开始前，清除上一次查询的残留数据，便于java的内存回收
	 */
	private void clean() {

		logger.info( "last query data clean start..." );
		if ( data != null ) {
			data = null;
		}
		clear();
	}

	private void clear() {

		logger.info( "temp data clear start..." );
		valuefilters = null;
		keyfilters = null;
		limit = -1;
		nextcost = 0;
		scansize = 0;
	}

	@Override
	public < T, S > QueryResult query( ColumnInterpreter< T, S > ci, Scan scan )
			throws IOException {

		logger.info( "start comprocessor on region:" + this.toString() );
		clean();

		// 获取查询端放入的查询条件
		byte[] bfilters = scan.getAttribute( TableConstants.VALUE_FILTERS_FLAG );
		if ( bfilters != null ) {
			logger.info( "VFILTERS:" + new String( bfilters ) );
			valuefilters = new ValueFilter( new String( bfilters ) );
		}
		byte[] bkfilters = scan.getAttribute( TableConstants.KEY_FILTERS_FLAG );
		if ( bkfilters != null ) {
			logger.info( "KFILTERS:" + new String( bkfilters ) );
			keyfilters = new KeyPartFilter( new String( bkfilters ) );
		}
		// 获取最大返回记录数
		byte[] nlimit = scan.getAttribute( TableConstants.LIMIT_FLAG );
		if ( nlimit != null ) {
			try {
				limit = Integer.parseInt( new String( nlimit ) );
				logger.info( "LIMIT:" + limit );
			} catch ( Exception e ) {
				limit = -1;
			}
		}
		List< KeyValue > results = new ArrayList< KeyValue >();
		InternalScanner scanner = ( ( RegionCoprocessorEnvironment ) getEnvironment() )
				.getRegion().getScanner( scan );
		// scan数据
		QueryResult data = buildResultData( results, scanner );
		data.setScansize( scansize );
		logger.info( "scan size:" + scansize );
		logger.info( "scan next cost:" + nextcost );
		logger.info( "complete comprocessor on region[" + this.toString() + "]" );
		clear();
		return data;
	}

	/**
	 * 把查询到的结果集放入DataBean对象，最大条数为limit
	 *
	 * @param data
	 * @param results
	 * @param scanner
	 * @param filters
	 * @throws IOException
	 */
	private QueryResult buildResultData( List< KeyValue > results,
	                                     InternalScanner scanner ) throws IOException {

		QueryResult qrs        = new QueryResult();
		long        resultSize = 0;
		// 是否有过滤条件
		boolean hasvaluefilter = valuefilters != null && valuefilters.getFilterCount() > 0;
		boolean haskeyfilter   = keyfilters != null && keyfilters.getFilterCount() > 0;
		// 是否有limit
		boolean haslimit = limit > 0;
		try {
			boolean  hasMoreRows = false;
			boolean  isok;
			byte[]   rowkey;
			byte[]   rrss;
			byte[]   qualifier;
			QueryRow queryRow;
			do {
				hasMoreRows = scanner.next( results );
				isok = true;
				if ( results.size() > 0 ) {
					scansize++;
					queryRow = new QueryRow();
					rowkey = results.get( 0 ).getRow();
//					logger.info(new String(rowkey).substring(14, 28));
					//先检查是否有对于key的过滤，通过的话把rowkey保存起来
					if ( haskeyfilter && !keyfilters.check( rowkey ) ) {
						results.clear();
						continue;
					} else {
//						logger.info("1ok");
						queryRow.addColumns( TableConstants.COMMON_ROWKEY_FLAG, rowkey );
					}
					for ( KeyValue kv : results ) {
						qualifier = kv.getQualifier();
						rrss = kv.getValue();
						// 不满足过滤条件,退出for循环,直接处下一条数据
						if ( hasvaluefilter && !valuefilters.check( qualifier, rrss ) ) {
							isok = false;
//							logger.info("不满足过滤条件,退出for循环,直接处下一条数据:" + isok+"  -- qualifier : "+qualifier+"    ------rrss"+rrss);
							break;
						} else {
//							logger.info("2ok");
							queryRow.addColumns( qualifier, rrss );
						}
					}
					// 满足全部过滤条件,添加数据
					if ( isok ) {
						qrs.addData( queryRow );
						resultSize++;
						// 超过了limit条数，退出do-while循环,结束处理
						if ( haslimit && resultSize > limit ) {
							results.clear();
							break;
						}
					}
				}
				results.clear();
			} while ( hasMoreRows );
		} finally {
			scanner.close();
		}
		return qrs;
	}

	@Override
	public < T, S > Long count( ColumnInterpreter< T, S > ci, Scan scan )
			throws IOException {

		Long count = 0L;
		logger.info( "start comprocessor on region :" + this.toString()
		             + " for count..." );
		clean();
		List< KeyValue > results   = new ArrayList< KeyValue >();
		byte[]           colFamily = scan.getFamilies()[ 0 ];

		scan.setFilter( new FirstKeyOnlyFilter() );

		scan.getFamilyMap().get( colFamily ).clear();

		InternalScanner scanner = ( ( RegionCoprocessorEnvironment ) getEnvironment() )
				.getRegion().getScanner( scan );
		// scan数据
		count = buildCountData( results, scanner );
		clear();
		return count;
	}

	private Long buildCountData( List< KeyValue > results, InternalScanner scanner )
			throws IOException {

		Long count = 0L;
		try {
			boolean hasMoreRows = false;
			do {
				hasMoreRows = scanner.next( results );
				if ( results.size() > 0 ) {
					count++;
				}
				results.clear();
			} while ( hasMoreRows );

		} finally {
			scanner.close();
		}
		return count;
	}
}
