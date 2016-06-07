package bj.mldn.javase02.ch04.no01;

public class ArrayDemo08 {

	public static void main( String args[] ) {

		int score[][] = new int[ 4 ][ 3 ];           // 声明并实例化二维数组
		score[ 0 ][ 1 ] = 30;                        // 为数组中的内容赋值
		score[ 1 ][ 0 ] = 31;                        // 为数组中的内容赋值
		score[ 2 ][ 2 ] = 32;                        // 为数组中的内容赋值
		score[ 3 ][ 1 ] = 33;                        // 为数组中的内容赋值
		score[ 1 ][ 1 ] = 30;                        // 为数组中的内容赋值


		for ( int i = 0; i < score.length; i++ ) {
			for ( int j = 0; j < score[ i ].length; j++ ) {
				System.out.print( score[ i ][ j ] + "\t" );
			}
			System.out.println( "" );
		}
	}

}
