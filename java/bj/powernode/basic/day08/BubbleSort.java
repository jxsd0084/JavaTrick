package bj.powernode.basic.day08;

public class BubbleSort {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int[] ints = { 3, 5, 9, 7, 6, 5, 0 };

		int temp;

		// 冒泡排序
		for ( int i = ints.length - 1; i >= 1; i-- ) {

			for ( int j = 0; j < i; j++ ) {

				if ( ints[ i ] < ints[ j ] ) {

					temp = ints[ i ];
					ints[ i ] = ints[ j ];
					ints[ j ] = temp;
				}

			}

		}

		// 遍历输出
		for ( int i = 0; i < ints.length; i++ ) {

			System.out.print( ints[ i ] + " " );
		}

	}

}
