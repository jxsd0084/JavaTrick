package bj.powernode.basic.day15;

/*

	找出某个目录下的所有的 .java文件

*/

import java.io.*;

public class TestFile {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		File f = new File( "D:/course/JavaProjects/day15" );

		if ( !f.exists() ) {

			System.out.println( f.getAbsolutePath() + "不存在" );

			return;
		}

		File[] files = f.listFiles( new FilenameFilter() {

			public boolean accept( File dir, String name ) {

				if ( name.endsWith( ".java" ) ) {

					return true;
				}

				return false;
			}

		} );


		// 遍历File数组
		for ( File f2 : files ) {

			System.out.println( f2.getName() );  // TestPrintStream.java
		}


	}

}


