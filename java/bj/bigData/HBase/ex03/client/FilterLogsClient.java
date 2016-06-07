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

public class FilterLogsClient {

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
		filters.add( new Filter( "HOUSE_ID", MatchType.EQUAL, "114710" ) );
		// filters.add(new Filter("DESTIP", MatchType.IPREGEX, "*.222.*.*"));
//		filters.add(new Filter("SRCIP", MatchType.IPRANGE,
//				"43.158.74.50,+" +
//				"+43.158.74.55"));
		filters.add( new Filter( "DESTIP", MatchType.IPRANGE,
				"84.179.84.134,84.179.84.135" ) );
		query.starttime = "2013-07-23 01:00:00";
		query.endtime = "2013-08-23 21:01:00";
		query.filters = filters;

		Result result = conn.queryFilterLog( cc, query );
		if ( result.getErrorcode() == 1 ) {
			System.out.println( result.getErrormsg() );
			return;
		}
		System.out.println( "total:" + result.getDatas().count );
		for ( String s : result.getDatas().getMetadata() ) {
			System.out.print( s + "|" );
		}
		System.out.println();
		System.out.println( result.getDatas().datas.get( 0 ).size() );
		for ( List< String > s : result.getDatas().datas ) {
			for ( String ps : s ) {
				System.out.print( ps + "|" );
			}
			System.out.println();
		}
		conn.close();
	}
}
