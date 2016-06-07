package bj.mldn.javase01.no07;

public class StringAPIDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str    = "hello world";

		String newStr = str.replaceAll( "l", "x" );

		System.out.println( newStr );

	}

}
