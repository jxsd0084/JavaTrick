package bj.powernode.basic.day14;

/*

	字符输入流

*/

import java.io.*;

public class TestFileReader {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Reader r = new FileReader( "D:/course/JavaProjects/day14/TestFileInputStream2.java" );

		// 读取.
		
		/*
			System.out.println((char)r.read());  // 一次读取一个字符
			System.out.println((char)r.read());  // 一次读取一个字符
			System.out.println((char)r.read());  // 一次读取一个字符
			System.out.println((char)r.read());  // 一次读取一个字符
		*/
		
		
		/*
			int temp = 0;
			while((temp=r.read())!=-1){
				System.out.print((char)temp);
			}
		*/


		char[] chars = new char[ 512 ];

		int temp = 0;
		while ( ( temp = r.read( chars ) ) != - 1 ) {

			System.out.print( new String( chars, 0, temp ) );
		}

		r.close();

	}

}
