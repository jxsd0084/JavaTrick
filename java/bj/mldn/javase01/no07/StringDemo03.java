package bj.mldn.javase01.no07;

public class StringDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str1 = "hello";              // 使用直接赋值的方式完成
		String str2 = new String( "hello" );  // 通过构造方法完成
		String str3 = str2;                 // 通过构造方法完成

		System.out.println( "str1 equals str2 --> " + str1.equals( str2 ) );    // true
		System.out.println( "str1 equals str3 --> " + str1.equals( str3 ) );    // true
		System.out.println( "str2 equals str3 --> " + str2.equals( str3 ) );    // true

	}

}
