package bj.powernode.basic.day07;


/*
	选择排序. Selection Sort
*/
public class _07_SelectionSort {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		int[] ints = { 4, 3, 6, 5, 2, 1, 9, 8, 7, 10, 0 };


		// 从小到大排序输出.

		int temp; // 临时变量
		for ( int i = 0; i < ints.length - 1; i++ ) {

			for ( int j = i + 1; j < ints.length; j++ ) {

				if ( ints[ i ] > ints[ j ] ) {

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
