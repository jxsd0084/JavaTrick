package bj.mldn.javase02.ch04.no01;

public class ArrayDemo09 {

	public static void main( String args[] ) {

		// 静态初始化完成，每行的数组元素个数不一样!
		int score[][] = {
				{ 67, 61 },
				{ 78, 89, 83 },
				{ 99, 100, 98, 66, 95 }
		};


		for ( int i = 0; i < score.length; i++ ) {
			for ( int j = 0; j < score[ i ].length; j++ ) {
				System.out.print( score[ i ][ j ] + "\t" );
			}
			System.out.println( "" );
		}
	}

}
