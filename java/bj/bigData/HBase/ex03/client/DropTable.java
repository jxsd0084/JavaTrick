package bj.bigData.HBase.ex03.client;

import com.boco.DataPlatform.hbase.common.utils.HbaseConfigUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;
import java.util.Properties;

public class DropTable {
	
	protected static     Properties pro        = HbaseConfigUtils.getConfigs();
	private static final String     quorum     = pro
			.getProperty( "hbase.zookeeper.quorum" );
	private static final String     clientPort = pro
			.getProperty( "hbase.zookeeper.property.clientPort" );

	protected Configuration conf;
	private   HBaseAdmin    admin;
	
	public DropTable() {

		conf = HBaseConfiguration.create();
		conf.set( "hbase.zookeeper.quorum", quorum );
		conf.set( "hbase.zookeeper.property.clientPort", clientPort );
		
	}

	public static void main( String[] args ) {

		String    tableName = "";
		DropTable dt        = new DropTable();
		dt.dropTable( tableName.split( "," ) );
	}

	public void dropTable( String[] tables ) {

		try {
			admin = new HBaseAdmin( conf );
			for ( String table : tables ) {
				admin.disableTable( table );
				admin.deleteTable( table );
			}
		} catch ( MasterNotRunningException e ) {
			
			e.printStackTrace();
		} catch ( ZooKeeperConnectionException e ) {
			
			e.printStackTrace();
		} catch ( IOException e ) {
			
			e.printStackTrace();
		}
	}
}
