package bj.crazy.ch03.u04;

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
public class TestFloat {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		float af = 5.2345556f;

		// 下面将看到af的值已经发生了改变
		System.out.println( af );
		double a = 0.0;
		double c = Double.NEGATIVE_INFINITY;
		float  d = Float.NEGATIVE_INFINITY;





		// 看到float和double的负无穷大的是相等的。
		System.out.println( c == d );




		// 0.0除以0.0将出现非数
		System.out.println( a / a );    //  NaN




		// 两个非数之间是不相等的
		System.out.println( a / a == Float.NaN );   // false




		// 所有正无穷大都是相等的
		System.out.println( 6.0 / 0 == 555.0 / 0 ); // true




		// 负数除以0.0得到负无穷大
		System.out.println( - 8 / a );  // -Infinity




		// 下面代码将抛出除以0的异常
		System.out.println(0 / 0);     // java.lang.ArithmeticException: / by zero



	}

}
