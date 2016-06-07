package bj.crazy.ch17.u02;

import java.net.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class InetAddressTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 根据主机名来获取对应的InetAddress实例

		InetAddress ip = InetAddress.getByName( "www.oneedu.cn" );

		// 判断是否可达

		System.out.println( "oneedu是否可达：" + ip.isReachable( 2000 ) );

		// 获取该InetAddress实例的IP字符串

		System.out.println( ip.getHostAddress() );







		// 根据原始IP地址来获取对应的InetAddress实例

		InetAddress local = InetAddress.getByAddress( new byte[]{ 127, 0, 0, 1 } );

		System.out.println( "本机是否可达：" + local.isReachable( 5000 ) );


		// 获取该InetAddress实例对应的全限定域名

		System.out.println( local.getCanonicalHostName() );







	}
}
