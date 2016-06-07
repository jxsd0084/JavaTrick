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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessLogsClient {

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

		QueryClient conn = CountClient.getQueryClient( "192.168.1.119", 8900 );
		// QueryServer qs =new QueryServer();
		CommonCondition cc = new CommonCondition( 0, 1000, 50000 );

		MainCondition  query   = new MainCondition();
		List< Filter > filters = new ArrayList< Filter >();
		filters.add( new Filter( "HOUSE_ID", MatchType.EQUAL, "100001000" ) );
//		filters.add(new Filter("IDC_ID", MatchType.EQUAL, "10035"));
//		 filters.add(new Filter("DESTIP", MatchType.IPREGEX, "211.151.*.*"));
//		 filters.add(new Filter("URL",MatchType.LIKE,"1004616"));

		// filters.add(new Filter("SRCIP", MatchType.IPRANGE,
		// "7.53.134.154,7.53.134.154"));
//		filters.add(new Filter("SRCIP", MatchType.EQUAL, "23.165.187.196"));
//		filters.add(new Filter("DESTIP", MatchType.EQUAL, "9.12.131.188"));
		Map< String, String > map = new HashMap< String, String >();
		map.put( "ISEXPORT", "1" );
//		map.put("commandId", "123456789");
		// 20130720103209
		query.starttime = "2013-10-16 01:20:00";  //2013-08-17 01:21:00
		query.endtime = "2013-10-16 01:59:59";
		
		query.filters = filters;
		query.setAttributes( map );
		Result result = conn.queryAccessLog( cc, query );
		if ( result.getErrorcode() == 1 ) {
			System.out.println( result.getErrormsg() );
			return;
		}
		if ( result.getErrorcode() == -1 ) {
			System.out.println( result.getErrormsg() );
			return;
		}
		if ( result.errorcode == 999 ) {
			System.out.print( result.errormsg );
			return;
		}
		if ( result.getDatas() == null ) {
			System.out.println( "没有匹配的数据!" );
			return;
		}
		for ( String s : result.getDatas().getMetadata() ) {
			System.out.print( s + "|" );
		}
		for ( List< String > s : result.getDatas().datas ) {
			for ( String ps : s ) {
				System.out.print( ps + "|" );
			}
			System.out.println();
		}
		conn.close();
	}
}
