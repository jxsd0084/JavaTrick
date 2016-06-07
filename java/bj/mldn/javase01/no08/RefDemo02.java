package bj.mldn.javase01.no08;

public class RefDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello";

		fun( str );

		System.out.println( str );

	}

	public static void fun( String temp ) {

		temp = "world";
	}

}
