package bj.mldn.javase02.ch03.no02;

public class OperateDemo17 {

	public static void main( String args[] ) {

		int x = 3;    // 3的二进制数据：	00000000 00000000 00000000 00000011
		System.out.println( x + "左移2位之后的内容：" + ( x << 2 ) );
		// 000000 00000000 00000000 0000001100
	}
}
