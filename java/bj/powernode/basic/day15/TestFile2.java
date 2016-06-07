package bj.powernode.basic.day15;

import java.io.*;

/*

	找出某个目录下的所有的 .java文件

*/
public class TestFile2 {

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

		File[] files = f.listFiles( new MyFilenameFilter() );


		// 遍历File数组
		for ( File f2 : files ) {

			System.out.println( f2.getName() );  // TestPrintStream.java
		}


	}

}


class MyFilenameFilter implements FilenameFilter {

	public boolean accept( File dir, String name ) {

		if ( name.endsWith( ".java" ) ) {

			return true;
		}

		return false;
	}
}


