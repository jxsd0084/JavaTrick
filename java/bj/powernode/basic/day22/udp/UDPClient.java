package bj.powernode.basic.day22.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基于UDP协议的Socket编程:客户端
 *
 * @author Administrator
 *         <p>
 *         DatagramPacket (数据报包对象)
 *         DatagramSocket (负责发送数据报包套接字)
 */
public class UDPClient {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 准备即将发送的数据
		String sendMsg = "hello world!";
		byte[] buf     = sendMsg.getBytes();

		// 准备一个数据报包对象,往数据报包对象存储即将发送的数据.
		DatagramPacket dp = new DatagramPacket( buf, buf.length, new InetSocketAddress( "127.0.0.1", 8888 ) );

		// 准备一个发送数据报包的套接字对象
		DatagramSocket ds = new DatagramSocket();

		// 发送数据报包
		ds.send( dp );

		// 关闭
		ds.close();

	}

}
