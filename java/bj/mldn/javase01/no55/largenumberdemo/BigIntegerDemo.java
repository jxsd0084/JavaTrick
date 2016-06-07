package bj.mldn.javase01.no55.largenumberdemo;

import java.math.BigInteger;

public class BigIntegerDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String     num1 = "9999999999999999999999999999999999";
		String     num2 = "9999999999999999999999999999999998";

		BigInteger big1 = new BigInteger( num1 ); // 实例化BigInteger对象
		BigInteger big2 = new BigInteger( num2 ); // 实例化BigInteger对象

		System.out.println( "加法操作：" + big1.add( big2 ) );
		System.out.println( "减法操作：" + big1.subtract( big2 ) );
		System.out.println( "乘法操作：" + big1.multiply( big2 ) );
		System.out.println( "除法操作：" + big1.divide( big2 ) );

		BigInteger result[] = big1.divideAndRemainder( big2 );    // 进行触发操作，有余数

		System.out.println( "相除之后的商是：" + result[ 0 ] );
		System.out.println( "相除之后的余数是：" + result[ 1 ] );

	}

}
