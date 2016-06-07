package bj.mldn.javase02.ch04.no03;

public class ArrayRefDemo02 {

	public static void main( String args[] ) {

		int temp[] = fun();            // 通过方法实例化数组
		print( temp );                 // 打印数组内容
	}

	public static void print( int x[] ) {

		for ( int i = 0; i < x.length; i++ ) {
			System.out.print( x[ i ] + "、" );
		}
	}

	public static int[] fun() {        // 返回一个数组
		int ss[] = { 1, 3, 5, 7, 9 };  // 定义一个数组
		return ss;
	}

}
