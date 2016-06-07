package bj.powernode.basic.day10;

import java.io.File;

public class FileUtil {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		FileUtil.listFiles( "c:/hello1" );
	}

	public static void listFiles( String pathname ) {

		File file = new File( pathname );

		if ( file.isDirectory() ) {

			File[] subFiles = file.listFiles();

			for ( int i = 0; i < subFiles.length; i++ ) {

				File subFile = subFiles[ i ];

				String subFileAbsolutePath = subFile.getAbsolutePath();

				System.out.println( subFileAbsolutePath );

				listFiles( subFileAbsolutePath );

			}

		}

	}

}
