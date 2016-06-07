package bj.bigData.HBase.ex03.query.service.scan;

import com.boco.DataPlatform.hbase.common.constants.TableConstants;
import com.boco.DataPlatform.hbase.query.endpoint.CdrCoprocessor;
import com.boco.DataPlatform.hbase.query.endpoint.ICoprocessor;
import com.boco.DataPlatform.hbase.query.service.common.CurrentPage;
import com.boco.DataPlatform.hbase.query.service.common.SessionStore.Session;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.log4j.Logger;

/**
 * 查询表的数据量
 *
 * @author ranhualin
 * @date 2013-7-19
 */
public class CountScanner extends BaseScanner implements Runnable {

	Logger logger = Logger.getLogger( CountScanner.class ); // 日志
	private Session      session     = null; // Session对象
	private ICoprocessor coprocessor = null;
	private String baseTable;

	public CountScanner( Session session, String baseTable, HTablePool pool,
	                     Configuration conf ) {

		super( conf );
		this.session = session;
		this.baseTable = baseTable;
		this.coprocessor = new CdrCoprocessor( pool );
		Thread.currentThread().setName( String.format( "TH%06d", session.getSid() ) );
	}

	@Override
	public void run() {

		logger.info( "Query Thread:" + session.getSid() + " start..." );
		if ( session == null ) {
			logger.error( "Empty Session" );
			return;
		}
		CurrentPage page = session.getPage();
		// scan
		Scan scan = new Scan();
		scan.addFamily( TableConstants.COMMON_COLUMN_FAMILY );
		Long count = 0L;
		logger.info( "start count table:" + baseTable + "..." );
		try {
			if ( checkTable( baseTable ) ) {// 表存在
				// 查询
				count = coprocessor.count( baseTable.getBytes(), scan );
			} else {
				logger.error( "table not Exists:" + baseTable );
			}
		} catch ( Throwable e ) {
			logger.error( "query table:" + baseTable + " error:" + e );
		}
		page.setIscount( true );
		page.setCountrs( count );
		session.notifyMe();
	}
}
