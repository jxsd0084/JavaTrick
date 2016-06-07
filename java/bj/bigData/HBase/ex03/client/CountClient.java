package bj.bigData.HBase.ex03.client;

import com.boco.DataPlatform.hbase.client.common.LocalClient;
import com.boco.DataPlatform.hbase.client.common.QueryClient;
import com.boco.DataPlatform.hbase.query.service.QueryServer;
import com.boco.DataPlatform.hbase.query.thrift.CountCondition;
import com.boco.DataPlatform.hbase.query.thrift.Result;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;

public class CountClient {

	private static final Logger logger = Logger.getLogger( QueryServer.class );

	public static LocalClient getClient( String ip, int port )
			throws TTransportException, IOException {

		TSocket   transport = new TSocket( ip, port );
		TProtocol protocol  = new TBinaryProtocol( transport );
		transport.open();
		LocalClient client = new LocalClient( protocol, port, transport );
		return client;
	}

	public static QueryClient getQueryClient( String ip, int port )
			throws TTransportException, IOException {

		TSocket   transport = new TSocket( ip, port );
		TProtocol protocol  = new TBinaryProtocol( transport );
		transport.open();
		QueryClient client = new QueryClient( protocol, port, transport );
		return client;
	}
	
	public static void main( String[] args ) throws IOException, TException {

		QueryClient conn = CountClient.getQueryClient( "10.0.7.216", 8900 );
//		20723571
		CountCondition query = new CountCondition();
		query.table = "TO_NET_ODS_MONITOR_IPINFO_20130803";
		query.timeout = 50000;
		Result result = conn.count( query );
		conn.close();
	}
}
