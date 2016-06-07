package bj.mldn.javase02.ch19.no04;

import java.io.*;
import java.net.*;

public class HelloServer {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		ServerSocket server = null;                 // 定义ServerSocket类
		Socket       client = null;                 // 表示客 户端
		PrintStream  out    = null;                 // 打印流输出最方便
		server = new ServerSocket( 8888 );          // 服务器在8888端口上监听
		System.out.println( "服务器运行，等待客户端连接。" );
		client = server.accept();                   // 得到连接，程序进入到阻塞状态
		String str = "hello world";                 // 表示要输出的信息
		out = new PrintStream( client.getOutputStream() );
		out.println( str );                         // 向客户端输出信息
		client.close();
		server.close();
	}
}
