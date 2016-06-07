package bj.powernode.basic.day22.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket编程: 服务器端
 *
 * @author Administrator
 *         <p>
 *         java应用程序的通信服务器端需要: java.net.ServerSocket(服务器端插座)
 */
public class TCPServer {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		/**
		 * 创建服务器端套接字对象.
		 */
		int          port         = 6666;
		ServerSocket serverSocket = new ServerSocket( port );  // 启动了一个端口号6666的应用程序.

		Socket         socket = null;
		BufferedReader reader = null;

		while ( true ) {

			socket = serverSocket.accept();  // 程序处于等待状态,等待客户端插座的接入

			// 接收客户端传递的数据. (读,输入)
			reader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

			// 开始读
			String fromClientMsg = reader.readLine();

			if ( fromClientMsg.equals( "byebye" ) ) {

				break;
			}

			System.out.println( "从客户端传送过来的消息是:" + fromClientMsg );
		}


		// 释放资源
		reader.close();
		socket.close();
		serverSocket.close();

	}

}
