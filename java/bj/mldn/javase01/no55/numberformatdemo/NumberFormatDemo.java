package bj.mldn.javase01.no55.numberformatdemo;

import java.text.NumberFormat;

public class NumberFormatDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		int          temp = 1000010000;

		NumberFormat num  = NumberFormat.getInstance();

		System.out.println( num.format( temp ) );

	}

}
