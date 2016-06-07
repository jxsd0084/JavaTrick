package bj.mldn.javase02.ch03.no02;

public class SimpleExpressDemo01 {

	public static void main( String args[] ) {

		int a = 5, b = 8;
		System.out.println( "改变之前的数是：a = " + a + "，b = " + b );
		a += b;    // 等价于a = a + b ;
		System.out.println( "改变之后的数是：a = " + a + "，b = " + b );
	}

}
