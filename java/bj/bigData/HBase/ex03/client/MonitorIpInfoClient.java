package bj.bigData.HBase.ex03.client;

import com.boco.DataPlatform.hbase.client.common.LocalClient;
import com.boco.DataPlatform.hbase.client.common.QueryClient;
import com.boco.DataPlatform.hbase.query.thrift.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitorIpInfoClient {

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

		QueryClient conn = getQueryClient( "10.0.7.216", 8900 );
		
		CommonCondition cc = new CommonCondition( 0, 1000, 50000 );
		
		MainCondition  query   = new MainCondition();
		List< Filter > filters = new ArrayList< Filter >();
		filters.add( new Filter( "HOUSE_ID", MatchType.EQUAL, "104000" ) );
		filters.add( new Filter( "SERVICE_IP", MatchType.IPREGEX, "*.*.*.*" ) );
		filters.add( new Filter( "IPINFO_ICPERROR", MatchType.EQUAL, "1" ) );
		query.starttime = "2013-07-26 14:15:00";
		query.endtime = "2013-07-26 14:16:38";
		query.filters = filters;
		
		Result result = conn.queryMonitorIpInfo( cc, query );
		System.out.println( "total:" + result.getDatas().count );
		for ( String s : result.getDatas().getMetadata() ) {
			System.out.print( s + "|" );
		}
		System.out.println();
		for ( List< String > s : result.getDatas().datas ) {
			for ( String ps : s ) {
				System.out.print( ps + "|" );
			}
			System.out.println();
		}
		conn.close();
	}
}
