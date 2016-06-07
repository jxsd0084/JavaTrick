package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo01 {

	public static void main( String args[] ) {

		String str1 = "hello";            // 定义字符串
		char   c[]  = str1.toCharArray();    // 将一个字符串变为字符数组
		for ( int i = 0; i < c.length; i++ ) {    // 循环输出
			System.out.print( c[ i ] + "、" );
		}
		System.out.println( "" );        // 换行
		String str2 = new String( c );    // 将全部的字符数组变为String
		String str3 = new String( c, 0, 3 );    // 将部分字符数组变为String
		System.out.println( str2 );        // 输出字符串
		System.out.println( str3 );        // 输出字符串
	}

}
