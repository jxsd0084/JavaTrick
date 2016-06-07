package bj.mldn.javase01.no69.scannerdemo;

import java.util.Scanner;

public class ScannerDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );
		int     i    = 0;
		if ( scan.hasNextInt() ) {
			i = scan.nextInt();
		}
		System.out.println( "i = " + i );
	}

}
