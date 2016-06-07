package bj.crazy.ch03.u07;

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
public class TestAssignOperator {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 为变量 str 赋值为 Java

		String str = "Java";



		// 为变量 pi 赋值为 3.14

		double pi = 3.14;



		// 为变量 visited 赋值为 true

		boolean visited = true;

		// 将变量 str 的值赋给 str2
		String str2 = str;
		int    a;
		int    b;
		int    c;

		// 通过为a, b , c赋值，四个变量的值都是 7
		a = b = c = 7;

		// 输出四个变量的值。
		System.out.println( a + "\n" + b + "\n" + c );


		double d1 = 12.34;

		// 将表达式的值赋给d2
		double d2 = d1 + 5;

		// 输出d2的值
		System.out.println( d2 );

	}

}
