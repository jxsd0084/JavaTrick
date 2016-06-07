package bj.mldn.javase01.no55.arraysdemo;

import java.util.Arrays;

public class ArraysDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int i1[] = { 1, 2, 3, 4, 5, 6 }; // 两个数组内容一样
		int i2[] = { 6, 5, 4, 3, 2, 1 }; // 两个数组内容一样

		Arrays.sort( i2 );

		System.out.println( Arrays.equals( i1, i2 ) );

		Arrays.fill( i2, 3 );            // 将数组2的内容全部填充为3

		System.out.println( Arrays.toString( i2 ) );    // 输出内容

	}

}
