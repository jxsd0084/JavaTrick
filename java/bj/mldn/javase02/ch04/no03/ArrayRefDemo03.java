package bj.mldn.javase02.ch04.no03;

public class ArrayRefDemo03 {

	public static void main( String args[] ) {

		int score[] = { 67, 89, 87, 69, 90, 100, 75, 90 };    // 定义整型数组
		int age[]   = { 31, 30, 18, 17, 8, 9, 1, 39 };        // 定义整型数组
		sort( score );        // 数组排序
		print( score );       // 数组打印
		System.out.println( "\n---------------------------" );
		sort( age );          // 数组排序
		print( age );         // 数组打印
	}

	public static void sort( int temp[] ) {        // 执行排序操作
		for ( int i = 1; i < temp.length; i++ ) {
			for ( int j = 0; j < temp.length; j++ ) {
				if ( temp[ i ] < temp[ j ] ) {
					int x = temp[ i ];
					temp[ i ] = temp[ j ];
					temp[ j ] = x;
				}
			}
		}
	}

	public static void print( int temp[] ) {        // 输出数组内容
		for ( int i = 0; i < temp.length; i++ ) {
			System.out.print( temp[ i ] + "\t" );
		}
	}

}
