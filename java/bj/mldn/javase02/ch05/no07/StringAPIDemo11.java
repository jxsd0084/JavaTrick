package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo11 {

	public static void main( String args[] ) {

		String str1 = "HELLO";            // 定义字符串
		String str2 = "hello";            // 定义字符串

		System.out.println( "\"HELLO\" equals \"hello\" " + str1.equals( str2 ) );
		System.out.println( "\"HELLO\" equalsIgnoreCase \"hello\" "
		                    + str1.equalsIgnoreCase( str2 ) );    // 不区分大小写的比较
	}

}
