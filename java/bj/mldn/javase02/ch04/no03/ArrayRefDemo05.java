package bj.mldn.javase02.ch04.no03;

public class ArrayRefDemo05 {

	public static void main( String args[] ) {

		int i1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };             // 源数组
		int i2[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };    // 目标数组
		copy( i1, 3, i2, 1, 3 );                              // 调用拷贝方法
		print( i2 );
	}

	// 源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度
	public static void copy( int s[], int s1, int o[], int s2, int len ) {

		for ( int i = 0; i < len; i++ ) {
			o[ s2 + i ] = s[ s1 + i ];              // 进行拷贝操作
		}
	}

	public static void print( int temp[] ) {        // 输出数组内容
		for ( int i = 0; i < temp.length; i++ ) {
			System.out.print( temp[ i ] + "\t" );
		}
	}

}
