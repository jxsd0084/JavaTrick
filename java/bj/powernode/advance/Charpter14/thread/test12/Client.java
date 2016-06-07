package bj.powernode.advance.Charpter14.thread.test12;

import java.io.*;
import java.net.*;

// 客户端
public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// 实现客户端套接字,套接字是两台机器间通信的端点
		Socket client = null;

		// 客户端读取键盘数据的流
		BufferedReader br = null;

		InputStreamReader isr = null;

		try {

			// 创建一个流套接字并将其连接到指定 IP 地址的指定端口号
			client = new Socket( "192.168.1.200", 5000 );

			// OutputStream getOutputStream()返回此套接字的输出流,由OurputStream out接收
			OutputStream out = client.getOutputStream();

			// PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式
			PrintStream ps = new PrintStream( out );

			// static InputStream in 此流对应于键盘输入或者由主机环境或用户指定的另一个输入源
			isr = new InputStreamReader( System.in );

			br = new BufferedReader( isr );

			// 准备String类型的局部变量s接收信息
			String s = null;

			while ( ( s = br.readLine() ) != null ) {
				if ( s.length() == 0 ) {
					continue;
				}

				// 使用Socket准备好ps,将从键盘获取的数据打印到服务器
				ps.println( s );

				// 如果接收到"exit",则客户端需要退出
				if ( "exit".equalsIgnoreCase( s ) ) {
					System.out.println( "客户端将要推出!" );
					// 循环终止
					break;
				}
			}
			// 注意UnknownHostException异常,如果在创建到远程主机的连接以便进行远程方法调用时发生
			// java.net.UnknownHostException，则抛出 UnknownHostException
		} catch ( UnknownHostException e ) {

			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// 如果客户端对象存在
			if ( client != null ) {
				try {
					// 要注意将客户端关闭掉close方法
					client.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
