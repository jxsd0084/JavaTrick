package bj.Java1200.col01.ch10_Commons组件.ch10_1_CommonsLang组件简介._220;

import org.apache.commons.lang.math.Fraction;

/**
 * 分数的常见运算
 */
public class FractionTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Fraction fraction1 = Fraction.getFraction( 1, 3 );// 创建小数1/3
		Fraction fraction2 = Fraction.getFraction( 1, 5 );// 创建小数1/5

		Fraction addition = fraction1.add( fraction2 );// 计算1/3 + 1/5
		System.out.println( "1/3 + 1/5 = " + addition );

		Fraction subtraction = fraction1.subtract( fraction2 );// 计算1/3 - 1/5
		System.out.println( "1/3 - 1/5 = " + subtraction );

		Fraction multiplication = fraction1.multiplyBy( fraction2 );// 计算1/3 * 1/5
		System.out.println( "1/3 * 1/5 = " + multiplication );

		Fraction division = fraction1.divideBy( fraction2 );// 计算1/3 / 1/5
		System.out.println( "1/3 / 1/5 = " + division );

		Fraction invert = fraction1.invert();// 计算1/3的倒数
		System.out.println( "1/3的倒数是：" + invert );

		Fraction pow = fraction1.pow( 2 ); // 计算1/3的平方
		System.out.println( "1/3的平方是：" + pow );

	}

}
