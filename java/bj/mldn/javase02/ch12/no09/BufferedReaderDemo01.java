package bj.mldn.javase02.ch12.no09;

import java.io.*;

public class BufferedReaderDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		BufferedReader buf = null;        // 声明对象
		buf = new BufferedReader( new InputStreamReader( System.in ) );    // 将字节流变为字符流
		String str = null;                // 接收输入内容
		System.out.print( "请输入内容：" );
		try {
			str = buf.readLine();         // 读取一行数据
		} catch ( IOException e ) {
			e.printStackTrace();          // 输出信息
		}
		System.out.println( "输入的内容为：" + str );
	}
}
