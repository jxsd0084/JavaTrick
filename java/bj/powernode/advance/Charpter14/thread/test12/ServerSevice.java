package bj.powernode.advance.Charpter14.thread.test12;

import java.io.*;
import java.net.*;

// 创建一个线程类去继承Thread
public class ServerSevice extends Thread {

	// Socket类型的属性
	private Socket socket;

	// 有参构造方法,将Socket类型的属性传入
	public ServerSevice( Socket socket ) {

		this.socket = socket;
		// 当创建对象时自动启动线程
		this.start();
	}

	// 重写父类的run方法
	public void run() {

		// 创建读取字符串的流
		BufferedReader br;

		// 得到客户端及服务器端的IP地址
		String clientAddr = socket.getInetAddress().getHostAddress();

		try {
			// 得到输入流
			br = new BufferedReader( new InputStreamReader(
					socket.getInputStream() ) );

			// 准备字符串接收信息
			String s = null;

			// while循环读取数据
			while ( ( s = br.readLine() ) != null ) {

				// 输出从客户端接收到的信息
				System.out.println( clientAddr + " 说:" + s );

				// 如果收到"exit"字符串
				if ( "exit".equals( s ) ) {

					// 输出客户端将要停止的信息
					System.out.println( clientAddr + "将要关闭,服务器线程也将要关闭!" );

					// 跳出while循环
					break;
				}
			}
		} catch ( IOException e ) {

			// 准备String类型的msg接收IO异常报出来的信息
			String msg = e.getMessage();

			// 如果得到了"Connection reset"字符串
			if ( "Connection reset".equals( msg ) ) {

				// 输出因客户端异常改变导致服务器端也要关闭的报错信息
				System.err.println( clientAddr + " 非正常关闭,服务器线程也要关闭!" );
			}
		} finally {

			// 如果客户端对象仍在
			if ( socket != null ) {
				try {

					// 要注意关闭掉客户端
					socket.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
