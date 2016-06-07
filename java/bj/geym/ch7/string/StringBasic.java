package bj.geym.ch7.string;

public class StringBasic {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		String str1 = new String( "abc" );
		String str2 = new String( "abc" );
		System.out.println( str1 == str2 );             //返回false
		System.out.println( str1 == str2.intern() );        //返回false
		System.out.println( "abc" == str2.intern() );       //返回true
		System.out.println( str1.intern() == str2.intern() );       //返回true
	}
}
