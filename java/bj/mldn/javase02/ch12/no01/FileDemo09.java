package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo09 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		File f       = new File( "d:" + File.separator );   // 实例化File类的对象
		File files[] = f.listFiles();                       // 列出全部内容

		for ( int i = 0; i < files.length; i++ ) {

			System.out.println( files[ i ] );
		}

	}

}
