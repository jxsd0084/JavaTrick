
package bj.powernode.basic.day16.exercise;

import java.lang.reflect.Method;

public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Class c = Class.forName( "com.dlpowernode.reflect.Student" );


		// 1.获取对象
		Object obj = c.newInstance();


		// 2.动态调用printInfo方法
		Method[] ms = c.getDeclaredMethods();

		for ( Method m : ms ) {

			if ( "printInfo".equals( m.getName() ) ) {

				m.invoke( obj, "孙二娘" );
				break;
			}
		}


	}

}
