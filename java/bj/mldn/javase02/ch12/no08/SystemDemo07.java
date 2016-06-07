package bj.mldn.javase02.ch12.no08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello";        // 声明一个非数字的字符串
		try {
			System.out.println( Integer.parseInt( str ) );    // 转型
		} catch ( Exception e ) {
			try {
				System.setOut(
						new PrintStream(
								new FileOutputStream( "d:"
								                      + File.separator + "err.log" ) ) );    // 输出重定向
			} catch ( Exception e1 ) {

			}
			System.out.println( e );
		}
	}
}
