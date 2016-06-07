package bj.mldn.javase02.ch19.no01;

import java.net.InetAddress;

public class InetAddressDemo {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {// 所有异常抛出
		InetAddress locAdd = null;
		InetAddress remAdd = null;
		locAdd = InetAddress.getLocalHost();    // 得到本机
		remAdd = InetAddress.getByName( "http://www.mldnjava.cn/" );
		System.out.println( "本机的IP地址：" + locAdd.getHostAddress() );
		System.out.println( "MLDNJAVA的IP地址：" + remAdd.getHostAddress() );
		System.out.println( "本机是否可达：" + locAdd.isReachable( 5000 ) );
	}
}
