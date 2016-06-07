package bj.powernode.basic.day14;
/*

	使用Reader/Writer 完成文件的拷贝

*/

import java.io.*;

public class CopyFile2 {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		FileReader r = new FileReader( "D:/course/JavaProjects/day14/CopyFile2.java" );
		FileWriter w = new FileWriter( "D:/course/JavaProjects/day14/CopyFile2.java.bak" );


		int    temp  = 0;
		char[] chars = new char[ 512 ];
		while ( ( temp = r.read( chars ) ) != -1 ) {

			w.write( chars, 0, temp );
		}


		w.flush();

		r.close();
		w.close();

	}

}
