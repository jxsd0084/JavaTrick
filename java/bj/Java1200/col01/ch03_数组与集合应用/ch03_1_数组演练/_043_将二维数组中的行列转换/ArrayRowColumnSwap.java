package bj.Java1200.col01.ch03_数组与集合应用.ch03_1_数组演练._043_将二维数组中的行列转换;

public class ArrayRowColumnSwap { // 创建类

	public static void main( String[] args ) {
		// 创建2维数组
		int arr[][] = new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println( "行列互调前：" );
		// 输出2维数组
		printArray( arr );
		int arr2[][] = new int[ arr.length ][ arr.length ];
		for ( int i = 0; i < arr.length; i++ ) {// 调整数组行列数据
			for ( int j = 0; j < arr[ i ].length; j++ ) {
				arr2[ i ][ j ] = arr[ j ][ i ];
			}
		}
		System.out.println( "行列互调后：" );
		// 输出2维数组
		printArray( arr );
	}

	private static void printArray( int[][] arr ) {

		for ( int i = 0; i < arr.length; i++ ) {// 遍历数组
			for ( int j = 0; j < arr.length; j++ ) {
				System.out.print( arr[ i ][ j ] + " " );// 输出数组元素
			}
			System.out.println();
		}
	}
}
