package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo08 {

	public static void main( String args[] ) {

		String str1 = "hello world";                // 定义字符串
		String s[]  = str1.split( " " );            // 按空格进行字符串的拆分
		for ( int i = 0; i < s.length; i++ ) {      // 循环输出
			System.out.println( s[ i ] );
		}
	}

}
