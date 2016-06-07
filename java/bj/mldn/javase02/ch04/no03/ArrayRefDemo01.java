package bj.mldn.javase02.ch04.no03;

public class ArrayRefDemo01 {

	public static void main( String args[] ) {

		int temp[] = { 1, 3, 5 };         // 利用静态初始化方式定义数组
		fun( temp );                      // 传递数组
		for ( int i = 0; i < temp.length; i++ ) {
			System.out.print( temp[ i ] + "、" );
		}
	}

	public static void fun( int x[] ) {   // 接收整型数组的引用
		x[ 0 ] = 6;                       // 修改第一个元素
	}

}
