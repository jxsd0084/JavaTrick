package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo08 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		File   f     = new File( "d:" + File.separator );         // 实例化File类的对象
		String str[] = f.list();                            // 列出给定目录中的内容

		for ( int i = 0; i < str.length; i++ ) {

			System.out.println( str[ i ] );
		}

	}

}
