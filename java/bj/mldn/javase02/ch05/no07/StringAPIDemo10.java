package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo10 {

	public static void main( String args[] ) {

		String str1 = "**HELLO";            // 定义字符串
		String str2 = "HELLO**";            // 定义字符串
		if ( str1.startsWith( "**" ) ) {    // 判断是否以“**”开头
			System.out.println( "（**HELLO）以**开头" );
		}
		if ( str2.endsWith( "**" ) ) {      // 判断是否以“**”结尾
			System.out.println( "（HELLO**）以**结尾" );
		}
	}

}
