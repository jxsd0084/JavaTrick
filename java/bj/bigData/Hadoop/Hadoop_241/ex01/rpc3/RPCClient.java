package bj.bigData.Hadoop.Hadoop_241.ex01.rpc3;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCClient {

	public static void main( String[] args ) throws IOException {

		Barty proxy = RPC.getProxy( Barty.class, 10010,
				new InetSocketAddress( "192.168.8.242", 9527 ), new Configuration() );
		String sayHi = proxy.sayHi( "tomcat" );
		System.out.println( sayHi );
	}

}
