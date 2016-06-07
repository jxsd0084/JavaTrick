package bj.mldn.javase01.no55.regextdemo;

public class StringRegexDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		String str   = "aa@aa.com.cn";

		String regex = "\\w+@\\w+.(com|net.cn)";

		System.out.println( str.matches( regex ) );

	}

}
