package bj.powernode.basic.day08;

/*

	二维数组(特殊的一维数组): 每一个元素都是一个一维数组.
	
	初始化： 静态初始化 + 动态初始化
	
	访问二维数组中的某个元素:  二维数组名[二维数组元素下标][二维数组元素(即一维数组)下标] 

*/
public class TwainArray {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/*
		 * 静态初始化二维数组
		 */
		int[][] ins1 = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 11 } };





		
		/*
		 * 第一种方式：动态初始化二维数组
		 */
		int[][] ins2 = new int[ 3 ][]; // {null,null,null}

		ins2[ 0 ] = new int[ 2 ];
		ins2[ 0 ][ 0 ] = 1;
		ins2[ 0 ][ 1 ] = 2;

		ins2[ 1 ] = new int[ 3 ];
		ins2[ 1 ][ 0 ] = 3;
		ins2[ 1 ][ 1 ] = 4;
		ins2[ 1 ][ 2 ] = 5;

		ins2[ 2 ] = new int[ 4 ];
		ins2[ 2 ][ 0 ] = 6;
		ins2[ 2 ][ 1 ] = 7;
		ins2[ 2 ][ 2 ] = 8;
		ins2[ 2 ][ 3 ] = 9;





		/*
		 *第二种方式：动态初始化二维数组 
		 */
		int[][] ins3 = new int[ 2 ][ 3 ]; // {{0,0,0},{0,0,0}}

		ins3[ 0 ][ 0 ] = 1;
		ins3[ 0 ][ 1 ] = 2;
		ins3[ 0 ][ 2 ] = 3;

		ins3[ 1 ][ 0 ] = 4;
		ins3[ 1 ][ 1 ] = 5;
		ins3[ 1 ][ 2 ] = 6;
		
		/*
		 *第三种方式：动态初始化二维数组 
		 */
		int[][] ins4 = new int[][]{ { 1, 2, 3 }, { 4, 5, 6, 7, 8 }, { 9, 10 } };

		for ( int i = 0; i < ins4.length; i++ ) {

			for ( int j = 0; j < ins4[ i ].length; j++ ) {

				System.out.print( ins4[ i ][ j ] + " " );
			}

			System.out.println();
		}


		// 一维数组

		int[] i1 = { 1, 2, 3 };

		int[] i2 = new int[ 3 ];
		i2[ 0 ] = 1;
		i2[ 1 ] = 2;
		i2[ 2 ] = 3;


		int[] i3 = new int[]{ 1, 2, 3 };


	}

}
