package bj.mldn.javase01.no07;

public class StringAPIDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello world !!!@";

		char   c[] = str.toCharArray();       // 将字符串变为字符数组

		for ( int i = 0; i < c.length; i++ ) {

			System.out.print( c[ i ] + "、" );
		}

		String str1 = new String( c );          // 将全部的字符数组重新变为String
		String str2 = new String( c, 0, 5 );    // 将0~5的字符数组重新变为String

		System.out.println( "\n" + str1 );
		System.out.println( str2 );

	}

}
