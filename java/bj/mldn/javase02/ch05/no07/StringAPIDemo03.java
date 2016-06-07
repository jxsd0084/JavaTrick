package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo03 {

	public static void main( String args[] ) {

		String str1 = "hello";                          // 定义字符串
		byte   b[]  = str1.getBytes();                  // 将字符串变为byte数组
		System.out.println( new String( b ) );          // 将全部的byte数组变为字符串
		System.out.println( new String( b, 1, 3 ) );    // 将部分的byte数组变为字符串
	}

}
