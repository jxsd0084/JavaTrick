package bj.mldn.javase01.no07;

public class StringAPIDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str  = "hello world !!!@";

		byte   b[]  = str.getBytes();       // 将字符串变为byte数组

		String str1 = new String( b );        // 将全部的字符数组重新变为String
		String str2 = new String( b, 0, 5 );  // 将0~5的字符数组重新变为String

		System.out.println( str1 );
		System.out.println( str2 );

	}

}
