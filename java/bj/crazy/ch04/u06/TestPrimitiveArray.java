package bj.crazy.ch04.u06;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestPrimitiveArray {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 定义一个int[]类型的数组变量
		int[] iArr;

		// 动态初始化 数组，数组长度为 5
		iArr = new int[ 5 ];







		// 采用循环方式为每个数组元素赋值。
		for ( int i = 0; i < iArr.length; i++ ) {

			iArr[ i ] = i + 10;
		}






	}

}
