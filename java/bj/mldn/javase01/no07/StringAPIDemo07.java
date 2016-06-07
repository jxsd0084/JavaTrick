package bj.mldn.javase01.no07;

public class StringAPIDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello world";

		String s[] = str.split( " " );    // 按照空格拆分

		for ( String st : s ) {

			System.out.println( st );
		}

	}

}
