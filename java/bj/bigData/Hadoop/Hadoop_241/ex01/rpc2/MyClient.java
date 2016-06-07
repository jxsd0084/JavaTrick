package bj.bigData.Hadoop.Hadoop_241.ex01.rpc2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

public class MyClient {

	public static void main( String[] args ) throws Exception {
		/**
		 * 构造一个客户端代理对象，该代理对象实现了命名的协议。代理对象会与指定地址的服务端通话
		 */
//		MyBizable proxy = (MyBizable)RPC.waitForProxy(
//					MyBizable.class,
//					MyBizable.versionID,
//					new InetSocketAddress(MyServer.ADDRESS, MyServer.PORT),
//					new Configuration());
//		final String result = proxy.hello("world");
//		System.out.println("客户端结果："+result);
//		//关闭网络连接
//		RPC.stopProxy(proxy);
		
		
		MyBizable proxy = ( MyBizable ) RPC.getProxy(
				MyBizable.class,
				MyBizable.versionID,
				new InetSocketAddress( MyServer.ADDRESS, MyServer.PORT ),
				new Configuration() );
		final String result = proxy.hello( "world" );
		System.out.println( "客户端结果：" + result );
		//关闭网络连接
		RPC.stopProxy( proxy );
	}

}
