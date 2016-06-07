package bj.mldn.javase02.ch04.no03;

public class ArrayRefDemo04 {

	public static void main( String args[] ) {

		int score[] = { 67, 89, 87, 69, 90, 100, 75, 90 };    // 定义整型数组
		int age[]   = { 31, 30, 18, 17, 8, 9, 1, 39 };        // 定义整型数组
		java.util.Arrays.sort( score );                       // 数组排序
		print( score );        // 数组打印
		System.out.println( "\n---------------------------" );
		java.util.Arrays.sort( age );            // 数组排序
		print( age );        // 数组打印
	}


	public static void print( int temp[] ) {        // 输出数组内容
		for ( int i = 0; i < temp.length; i++ ) {
			System.out.print( temp[ i ] + "\t" );
		}
	}

}
