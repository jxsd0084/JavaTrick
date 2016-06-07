package bj.powernode.basic.day22.tcp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 基于TCP协议的Socket编程: 客户端
 *
 * @author Administrator
 *         <p>
 *         通信需要java.net.Socket(客户端的插座)
 */

public class TCPClient {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		/**
		 * 创建客户端套接字对象,该对象应该包装即将访问的服务器的    IP地址+端口号
		 * 找到网络中的哪台服务器(IP)，访问这个服务器上的哪个应用程序.(PORT)
		 */
		String ip     = "127.0.0.1";
		int    port   = 6666;
		Socket socket = new Socket( ip, port );  // 会在网络中寻址.


		// 客户端向服务器端发送消息.IO
		// 写,输出(OutputStream)
		// 通过 客户端插座对象获取输出流(向服务器端写数据)
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );

		writer.write( "byebye" );

		writer.flush();


		// 释放资源
		writer.close();
		socket.close();

	}

}
