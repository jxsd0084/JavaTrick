package bj.powernode.basic.day14;

import java.io.*;

public class TestBufferedReader {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		FileInputStream   fis = new FileInputStream( "D:/course/JavaProjects/day14/day14.txt" );

		InputStreamReader isr = new InputStreamReader( fis );
		BufferedReader    br  = new BufferedReader( isr );


		// 读取
		
		/*
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		*/

		// 循环读取.
		String temp = "";
		while ( ( temp = br.readLine() ) != null ) {

			System.out.println( temp );
		}

		br.close();

	}

}
