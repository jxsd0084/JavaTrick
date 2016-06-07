package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( "pathSeparator：" +
		                    File.pathSeparator );    // 调用静态常量

		System.out.println( "separator：" +
		                    File.separator );        // 调用静态常量
	}
}