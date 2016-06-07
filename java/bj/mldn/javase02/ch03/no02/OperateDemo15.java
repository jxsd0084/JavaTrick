package bj.mldn.javase02.ch03.no02;

public class OperateDemo15 {

	public static void main( String args[] ) {

		int x = 3;        // 3的二进制数据：	00000000 00000000 00000000 00000011
		int y = 6;        // 6的二进制数据：	00000000 00000000 00000000 00000110

		System.out.println( x & y );    //与：	00000000 00000000 00000000 00000010
		System.out.println( x | y );    //或：	00000000 00000000 00000000 00000111
		System.out.println( x ^ y );    //或：	00000000 00000000 00000000 00000101
	}

}
