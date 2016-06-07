package bj.mldn.javase02.ch12.no08;

import java.io.IOException;
import java.io.OutputStream;

public class SystemDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		OutputStream out = System.out;        // 此时的输出流是向屏幕上输出
		try {
			out.write( "hello world!!!".getBytes() );    // 向屏幕上输出
		} catch ( IOException e ) {
			e.printStackTrace();    // 打印异常
		}
		try {
			out.close();    // 关闭输出流
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
