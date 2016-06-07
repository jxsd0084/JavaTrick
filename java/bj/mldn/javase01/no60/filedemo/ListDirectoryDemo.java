package bj.mldn.javase01.no60.filedemo;

import java.io.File;

public class ListDirectoryDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		File file = new File( "d:" + File.separator );
		list( file );
	}

	public static void list( File file ) {

		if ( file.isDirectory() ) {
			File lists[] = file.listFiles();
			if ( lists != null ) {
				for ( int i = 0; i < lists.length; i++ ) {
					list( lists[ i ] ); // 列出内容
				}
			}
		}
		System.out.println( file );
	}
}
