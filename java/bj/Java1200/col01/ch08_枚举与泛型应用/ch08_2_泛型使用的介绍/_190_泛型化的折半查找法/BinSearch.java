package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._190_泛型化的折半查找法;

import java.util.Arrays;

/**
 * 泛型化的折半查找法
 */
public class BinSearch {

	public static < T extends Comparable< ? super T > > int search( T[] array, T key ) {

		int low  = 0;
		int mid  = 0;
		int high = array.length;
		System.out.println( "查找的中间值：" );
		while ( low <= high ) {
			mid = ( low + high ) / 2;
			System.out.print( mid + " " );
			if ( key.compareTo( array[ mid ] ) > 0 ) {
				low = mid + 1;
			} else if ( key.compareTo( array[ mid ] ) < 0 ) {
				high = mid - 1;
			} else {
				System.out.println();
				return mid;
			}
		}
		return - 1;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println( "数据集合：" );
		System.out.println( Arrays.toString( ints ) );
		System.out.println( "元素3所对于的索引序号：" + search( ints, 3 ) );

	}

}
