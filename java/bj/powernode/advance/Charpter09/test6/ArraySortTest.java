package bj.powernode.advance.Charpter09.test6;

import java.util.Arrays;

// 对数组里面的数据进行排序
public class ArraySortTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		int[] arr = { 2, 4, 6, 5, 1, 32, 9, 0 };
		Arrays.sort( arr );
		for ( int i : arr ) {
			System.out.println( i );
		}
	}
}
