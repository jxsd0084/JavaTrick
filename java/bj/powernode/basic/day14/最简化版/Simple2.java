package bj.powernode.basic.day14.最简化版;

import java.io.*;

public class Simple2 {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		FileInputStream fis = new FileInputStream( "D:/course/JavaProjects/day14/FirstFile" );

		int temp;

		byte[] bytes = new byte[ 1024 ];

		while ( ( temp = fis.read( bytes ) ) != -1 ) {

			System.out.print( new String( bytes, 0, temp ) );
		}


		fis.close();

	}

}	
