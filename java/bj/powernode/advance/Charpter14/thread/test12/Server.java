package bj.powernode.advance.Charpter14.thread.test12;

import java.io.IOException;
import java.net.*;

// 服务器端
public class Server {

	// 主方法
	public static void main( String[] args ) {

		// 服务器套接字等待请求通过网络传入
		ServerSocket server = null;

		try {

			// 创建绑定到特定端口的服务器套接字
			server = new ServerSocket( 5000 );
			System.out.println( "服务器已经启动" );
			while ( true ) {

				// Socket accept()侦听并接受到此套接字的连接
				// server.accept()方法会阻塞的等待客户端的链接请求
				// 当接收到一个客户度的连接请求之后,accept()方法会被激活
				// 并且返回一个Socket
				Socket socket = server.accept();

				// 创建服务器服务对象
				new ServerSevice( socket );
			}

		} catch ( IOException e ) {

			e.printStackTrace();
		} finally {

			// 如果服务存在
			if ( server != null ) {
				try {

					// 要注意将服务关闭掉close方法
					server.close();
				} catch ( IOException e ) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
