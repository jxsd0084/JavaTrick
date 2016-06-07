package bj.mldn.javase02.ch04.no01;

public class ArrayDemo10 {

	public static void main( String args[] ) {

		// 静态初始化完成，每行的数组元素个数不一样!
		int score[][][] = {
				{
						{ 5, 1 }, { 6, 7 }
				},
				{
						{ 9, 4 }, { 8, 3 }
				}
		};

		for ( int i = 0; i < score.length; i++ ) {

			for ( int ii = 0; ii < score[ i ].length; ii++ ) {

				for ( int iii = 0; iii < score[ i ][ ii ].length; iii++ ) {
					System.out.println( "score[" + i + "][" + ii + "][" + iii + "] = " + score[ i ][ ii ][ iii ] + "\t" );
				}
			}
		}
	}

}
