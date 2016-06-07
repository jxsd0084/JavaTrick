package bj.mldn.javase02.ch03.no01;

public class DataDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		char ch1 = 'a'; // 字符是使用”'“括起来的数据
		char ch2 = 97;  // 通过数字定义字符变量

		System.out.println( "ch1 = " + ch1 );
		System.out.println( "ch2 = " + ch2 );


		String str   = "abc";
		char[] chArr = { 'a', 'b', 'c' };
		chArr = new char[ 3 ];
		chArr = str.toCharArray();



	}
}
