package bj.geym.ch11.inv;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invokeSpecial
 *
 * @author Administrator
 */
public class SimpleStaticMethodHandle {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Throwable {

		SimpleStaticMethodHandle obj = new SimpleStaticMethodHandle();
		System.out.println( obj.callSin() );
	}

	public double callSin() throws Throwable {

		MethodHandle mh = MethodHandles.lookup().findStatic( Math.class, "sin",
		                                                     MethodType.methodType( double.class, double.class ) );
		return (double) mh.invokeExact( Math.PI / 2 );
	}
}
