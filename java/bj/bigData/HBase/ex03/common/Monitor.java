package bj.bigData.HBase.ex03.common;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 监控程序运行状态
 *
 * @author ranhualin
 * @date 2013-4-16
 */
public class Monitor extends Thread {

	private              long   interval = 1000L;
	private static final Logger logger   = Logger
			.getLogger( Monitor.class );
	
	Configuration conf;
	int cnt = 0;

	public Monitor( long interval, Configuration conf ) {

		this.interval = interval;
		this.conf = conf;
	}

	public void run() {

		while ( true ) {
			logger.info( "--------------------" );
			getMemoryStatus();
			if ( cnt % 10 == 0 ) {
				showAllTables();
			}
			cnt++;
			logger.info( "--------------------" );
			try {
				Thread.sleep( interval );
			} catch ( InterruptedException e ) {
			}
		}
	}

	private void getMemoryStatus() {

		int maxMemory   = ( int ) ( Runtime.getRuntime().maxMemory() / ( 1024 * 1024 ) );
		int totalMemory = ( int ) ( Runtime.getRuntime().totalMemory() / ( 1024 * 1024 ) );
		int freeMemory  = ( int ) ( Runtime.getRuntime().freeMemory() / ( 1024 * 1024 ) );
		logger.info( "maxMemory:" + maxMemory + " m,totalMemory:" + totalMemory + "m,freeMemory:" + freeMemory + "m" );
	}

	private void showAllTables() {

		HBaseAdmin admin;
		String     s = "";
		try {
			admin = new HBaseAdmin( conf );
			HTableDescriptor[] tables = admin.listTables();
			for ( HTableDescriptor table : tables ) {
				s = s + "\n" + new String( table.getName() );
			}
			logger.info( "all table:" + s + "\n" );
		} catch ( MasterNotRunningException e ) {
			
			e.printStackTrace();
		} catch ( ZooKeeperConnectionException e ) {
			
			e.printStackTrace();
		} catch ( IOException e ) {
			
			e.printStackTrace();
		}
		
	}
}
