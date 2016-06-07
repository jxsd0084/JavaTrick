package bj.jakeChen.PlayGround;

import java.util.Arrays;

/**
 * Created by chenlong on 2016/5/24.
 */
/*

练习数组插入

*/
public class Test01 {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		int[] arr = { 1, 3, 4, 5, 6 };

		printArray( arr );

//		insertArray( 1, 2, arr );
//		insertArray2( 1, 2, arr );
//		insertArray3( 2, arr );
		insertArray4( 1, 2, arr );

		printArray( arr );

	}

	/**
	 * 拷贝数组
	 *
	 * @return
	 */
	public static int[] copyArray( int[] arr ) {
		int[] tmp = new int[ arr.length + 1 ];
		for ( int i = 0; i < arr.length; i++ ) {
			tmp[ i ] = arr[ i ];
		}
		return tmp;
	}

	/**
	 * 插入元素到数组中 ( 从后往前挪 )
	 *
	 * @param num
	 */
	public static void insertArray( int index, int num, int[] arr ) {
		int[] tmp = copyArray( arr );
		printArray( tmp );

		for ( int i = tmp.length - 1; i > index; i-- ) {
			tmp[ i ] = tmp[ i - 1 ];
		}
		tmp[ index ] = num;
		printArray( tmp );
	}

	/**
	 * 插入元素到数组中 ( 从前往后挪 )
	 *
	 * @param index
	 * @param num
	 * @param arr
	 */
	public static void insertArray2( int index, int num, int[] arr ) {
		int[] tmp = copyArray( arr );
		printArray( tmp );

		int arr2[] = new int[ tmp.length - index - 1 ]; // 临时数组用来保存变量
		for ( int i = index; i < tmp.length - index; i++ ) {
			arr2[ i - 1 ] = tmp[ i ];
		}
		printArray( arr2 );

		tmp[ index ] = num;
		for ( int i = index + 1, j = 0; i < tmp.length && j < arr2.length; i++, j++ ) {
			tmp[ i ] = arr2[ j ];
		}
		printArray( tmp );

	}

	/**
	 * 插入元素到数组中 ( 参考ArrayAlgorithm.java代码 )
	 */
	public static void insertArray3( int num, int[] arr ) {
		Arrays.sort( arr ); // 先排序
		for ( int i = 1; i < arr.length; i++ ) { // 比较大小再插入
//			if ( ( num > arr[ i ] ) && ( num < arr[ i - 1 ] ) ) {
			boolean flag1 = num < arr[ i ];
			boolean flag2 = num > arr[ i - 1 ];
			if ( flag1 && flag2 ) {
				arr[ i ] = num; // 妈蛋! 这哪里是插入数据啊~ 明明是覆盖数据!
				break;
			}
		}
		printArray( arr );
	}

	/**
	 * 插入元素到数组中 ( 参考ArrayList.java add()方法代码 )
	 */
	public static void insertArray4( int index, int num, int[] arr ) {
		int[] tmp = copyArray( arr );
		printArray( tmp );

		int size = arr.length;
		System.arraycopy( arr, index, tmp, index + 1,
				size - index );
		tmp[ index ] = num;
		printArray( tmp );
	}

	/**
	 * 打印数组
	 *
	 * @param arr
	 */
	public static void printArray( int[] arr ) {
		for ( int i = 0; i < arr.length; i++ ) {
			if ( i == arr.length - 1 ) {
				System.out.println( arr[ i ] );
			} else {
				System.out.print( arr[ i ] + ", " );
			}
		}
		System.out.println();
	}

}
