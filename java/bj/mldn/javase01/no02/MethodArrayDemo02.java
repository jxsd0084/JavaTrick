package bj.mldn.javase01.no02;

public class MethodArrayDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		int[] temp = null;
		temp = fun();    // 声明数组

		print( temp );

	}

	public static int[] fun() {

		int x[] = { 1, 3, 5, 7, 9 };
		return x;    // 返回数组
	}

	public static void print( int[] x ) {

		for ( int i = 0; i < x.length; i++ ) {

			System.out.print( x[ i ] + "、" );
		}
	}
}
