package bj.powernode.basic.day14.最简化版;

import java.io.*;

public class Simple {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		FileInputStream fis = new FileInputStream( "D:/course/JavaProjects/day14/FirstFile" );

		int temp;
		while ( ( temp = fis.read() ) != -1 ) {

			System.out.print( (char) temp );
		}

		fis.close();

	}

}	
