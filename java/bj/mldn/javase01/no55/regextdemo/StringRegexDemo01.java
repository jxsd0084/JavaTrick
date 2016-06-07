package bj.mldn.javase01.no55.regextdemo;

public class StringRegexDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		String str = "aaaaaaaaa";

		System.out.println( str.matches( "\\w{6,15}" ) );

	}

}
