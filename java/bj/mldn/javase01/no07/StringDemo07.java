package bj.mldn.javase01.no07;

public class StringDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello";

		for ( int i = 0; i < 100; i++ ) {

			str += i;
		}
		System.out.println( str );

	}

}
