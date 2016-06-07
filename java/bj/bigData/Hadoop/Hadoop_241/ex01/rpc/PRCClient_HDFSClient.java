package bj.bigData.Hadoop.Hadoop_241.ex01.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class PRCClient_HDFSClient {

	public static void main( String[] args ) throws IOException {

		ClientProtocal proxy = RPC.getProxy( ClientProtocal.class,
				123123l,
				new InetSocketAddress( "192.168.8.242", 9123 ),
				new Configuration() );
		String findMetaDataByName = proxy.findMetaDataByName( "/words.txt" );
		System.out.println( findMetaDataByName );
		
		String findMetaDataByName2 = proxy.findMetaDataByName( "/words2.txt" );
		System.out.println( findMetaDataByName2 );
		
		RPC.stopProxy( proxy );
	}

}


