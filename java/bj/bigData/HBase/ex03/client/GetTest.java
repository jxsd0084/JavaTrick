package bj.bigData.HBase.ex03.client;

import com.boco.DataPlatform.hbase.common.utils.HbaseConfigUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetTest {

	protected static     Properties pro        = HbaseConfigUtils.getConfigs();
	private static final String     quorum     = pro
			.getProperty( "hbase.zookeeper.quorum" );
	private static final String     clientPort = pro
			.getProperty( "hbase.zookeeper.property.clientPort" );

	protected Configuration conf;
	private   HBaseAdmin    admin;

	public GetTest() {

		conf = HBaseConfiguration.create();
		conf.set( "hbase.zookeeper.quorum", quorum );
		conf.set( "hbase.zookeeper.property.clientPort", clientPort );
	}

	public void getTest1() throws IOException {

		HTable table = new HTable( conf, "TO_NET_ODS_MONITOR_IPINFO_20130805" );
		for ( int i = 0; i < 1000; i++ ) {
			table.get( new Get( "000011201308050911173705065".getBytes() ) );
		}
	}

	public void getTest2() throws IOException {

		HTable      table = new HTable( conf, "TO_NET_ODS_MONITOR_IPINFO_20130805" );
		List< Get > list  = new ArrayList< Get >();
		for ( int i = 0; i < 1000; i++ ) {
			list.add( new Get( "000011201308050911173705065".getBytes() ) );
		}
		table.get( list );
	}

	public static void main( String[] args ) throws IOException {

		GetTest gt = new GetTest();
		gt.getTest2();
		gt.getTest1();
		gt.getTest1();
		gt.getTest2();
	}
}
