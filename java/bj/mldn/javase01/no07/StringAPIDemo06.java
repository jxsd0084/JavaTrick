package bj.mldn.javase01.no07;

public class StringAPIDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str  = "hello world";

		String sub1 = str.substring( 6 );

		String sub2 = str.substring( 0, 5 );

		System.out.println( sub1 );
		System.out.println( sub2 );

	}

}
