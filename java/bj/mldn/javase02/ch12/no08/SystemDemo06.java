package bj.mldn.javase02.ch12.no08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		System.setOut(
				new PrintStream(
						new FileOutputStream( "d:" +
						                      File.separator + "red.txt" ) ) );    // System.out输出重定向
		System.out.print( "www.mldnjava.cn" );    // 输出时，不再向屏幕上输出
		System.out.println( "，李兴华" );
	}
}
