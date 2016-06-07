package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo05 {

	public static void main( String args[] ) {

		String str1 = "abcdefgcgh";                     // 声明字符串
		System.out.println( str1.indexOf( "c" ) );      // 查到返回位置
		System.out.println( str1.indexOf( "c", 3 ) );   // 查到返回位置，从第4个位置开始查找
		System.out.println( str1.indexOf( "x" ) );      // 没有查到返回-1
	}

}
