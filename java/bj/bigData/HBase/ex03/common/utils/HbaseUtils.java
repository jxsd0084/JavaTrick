package bj.bigData.HBase.ex03.common.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;
import java.util.Properties;

//import com.boco.DataPlatform.hbase.importer.create.WordSplitter;

public class HbaseUtils {

	private static Properties prop = HbaseConfigUtils.getConfigs();

	private static String quorum     = prop.getProperty( "hbase.zookeeper.quorum" );
	private static String clientPort = prop
			.getProperty( "hbase.zookeeper.property.clientPort" );
	
	private static String DEF_F = "f";
	private static String DEF_C = "c";
	
	private static Configuration conf;

	/**
	 * 获取Hbase的Configuration
	 *
	 * @return
	 */
	public static Configuration getConf() {

		if ( conf == null ) {
			conf = HBaseConfiguration.create();
			conf.set( "hbase.zookeeper.quorum", quorum );
			conf.set( "hbase.zookeeper.property.clientPort", clientPort );
		}
		return conf;
	}

	/**
	 * 检查表是否存在
	 *
	 * @param table
	 * @return
	 */
	public static boolean checkTable( String table ) {

		HBaseAdmin admin;
		try {
			admin = new HBaseAdmin( getConf() );
			return admin.tableExists( table );
		} catch ( MasterNotRunningException e ) {
			e.printStackTrace();
		} catch ( ZooKeeperConnectionException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dropTable( String tableName ) {

		HBaseAdmin admin;
		try {
			admin = new HBaseAdmin( getConf() );
			admin.disableTable( tableName.getBytes() );
			admin.deleteTable( tableName.getBytes() );
			return true;
		} catch ( MasterNotRunningException e ) {
			e.printStackTrace();
		} catch ( ZooKeeperConnectionException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return false;
	}
}
