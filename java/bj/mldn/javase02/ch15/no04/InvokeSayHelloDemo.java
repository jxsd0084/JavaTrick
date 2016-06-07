package bj.mldn.javase02.ch15.no04;

import java.lang.reflect.Method;

public class InvokeSayHelloDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Class< ? > c1 = null;
		try {
			c1 = Class.forName( "org.lxh.demo15.Person" );    // 实例化Class对象
		} catch ( Exception e ) {
		}
		try {
			Method met = c1.getMethod( "sayHello", String.class, int.class );    // 找到sayChina()方法
			String rv  = null;
			rv = (String) met.invoke( c1.newInstance(), "李兴华", 30 );    // 调用方法
			System.out.println( rv );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
