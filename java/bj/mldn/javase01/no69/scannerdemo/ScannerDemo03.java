package bj.mldn.javase01.no69.scannerdemo;

import java.util.Scanner;

public class ScannerDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );
		String  str  = null;
		if ( scan.hasNext( "\\d{4}-\\d{2}-\\d{2}" ) ) {
			str = scan.next();
		}
		System.out.println( "str = " + str );
	}
}
