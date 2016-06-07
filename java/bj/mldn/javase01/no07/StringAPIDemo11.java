package bj.mldn.javase01.no07;

public class StringAPIDemo11 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "    hello world     ";

		System.out.println( str.trim() );

		System.out.println( str.trim().toUpperCase() );

		System.out.println( str.trim().length() );

	}

}
