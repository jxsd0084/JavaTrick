package bj.mldn.javase02.ch12.no08;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		ByteArrayOutputStream bos = null;           // 声明内存输出流
		bos = new ByteArrayOutputStream();          // 实例化
		System.setErr( new PrintStream( bos ) );    // 输出重定向
		System.err.print( "www.mldnjava.cn" );      // 错误输出，不再向屏幕上输出
		System.err.println( "李兴华" );              // 向内存中输出
		System.out.println( bos );                  // 输出内存中的数据
	}
}
