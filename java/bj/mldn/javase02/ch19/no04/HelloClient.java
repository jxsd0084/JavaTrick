package bj.mldn.javase02.ch19.no04;

import java.io.*;
import java.net.*;

public class HelloClient {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		Socket client = null;           // 表示客 户端
		client = new Socket( "localhost", 8888 );
		BufferedReader buf = null;      // 一次性接收完成
		buf = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
		String str = buf.readLine();
		System.out.println( "服务器端输出内容：" + str );
		buf.close();
		client.close();
	}
}
