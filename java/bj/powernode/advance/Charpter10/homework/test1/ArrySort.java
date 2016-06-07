package bj.powernode.advance.Charpter10.homework.test1;

/*在不新开数组的情况下,将数组里面的数据进行倒序*/

public class ArrySort {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int[] arr = { 1, 2, 3, 4, 5 };

		reverse( arr );

		printArr( arr );

	}

	public static void printArr( int[] arr ) {

		for ( int i : arr ) {
			System.out.println( i );
		}
	}

	public static void reverse( int[] arr ) {

		for ( int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j-- ) {
			int temp = arr[ i ];
			arr[ i ] = arr[ j ];
			arr[ j ] = temp;
		}
	}

}
