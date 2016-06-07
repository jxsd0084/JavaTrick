package bj.powernode.basic.day22.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基于UDP协议的Socket编程:服务器端
 *
 * @author Administrator
 *         <p>
 *         DatagramPacket (数据报包对象)
 *         DatagramSocket (负责接收数据报包的套接字)
 */
public class UDPServer {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 准备一个byte数组
		byte[] buf = new byte[ 1024 ];

		// 准备一个数据报包对象(空的,接收客户端数据报包)
		DatagramPacket dp = new DatagramPacket( buf, buf.length );

		// 准备一个接收数据报包的套接字对象
		DatagramSocket ds = new DatagramSocket( 8888 );

		// 接收
		ds.receive( dp );

		// 把接收到的内容打印到控制台
		System.out.println( new String( buf, 0, dp.getLength() ) ); // datagramPacket.getLength()方法获取一共接收的字节数

		// 关闭
		ds.close();

	}

}
