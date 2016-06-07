package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._157;

import java.lang.reflect.Method;

/**
 * 动态调用类中的方法
 */
public class MethodTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			System.out.println( "调用Math类的静态方法sin()" );
			Method sin  = Math.class.getDeclaredMethod( "sin", Double.TYPE );
			Double sin1 = (Double) sin.invoke( null, new Integer( 1 ) );
			System.out.println( "1的正弦值是：" + sin1 );
			System.out.println( "调用String类的非静态方法equals()" );
			Method  equals = String.class.getDeclaredMethod( "equals", Object.class );
			Boolean mrsoft = (Boolean) equals.invoke( new String( "明日科技" ), "明日科技" );
			System.out.println( "字符串是否是明日科技：" + mrsoft );

		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
