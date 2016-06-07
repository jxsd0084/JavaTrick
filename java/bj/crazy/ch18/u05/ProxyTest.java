package bj.crazy.ch18.u05;

import java.lang.reflect.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
interface Person {

	void walk();

	void sayHello( String name );
}

class MyInvokationHandler implements InvocationHandler {

	/*

		执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法

		其中：

		proxy－代表动态代理对象

		method－代表正在执行的方法

		args－代表执行代理对象方法时传入的实参。

	*/
	public Object invoke( Object proxy, Method method, Object[] args ) {

		System.out.println( "正在执行的方法:" + method );

		if ( args != null ) {

			System.out.println( "下面是执行该方法时传入的实参:" );
			for ( Object val : args ) {
				System.out.println( val );
			}

		} else {

			System.out.println( "调用该方法无需实参！" );
		}

		return null;
	}
}

public class ProxyTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {



		// 创建一个 InvocationHandler 对象

		InvocationHandler handler = new MyInvokationHandler();





		// 使用指定的InvocationHandler来生成一个 动态代理对象

		Person p = (Person) Proxy.newProxyInstance(
				Person.class.getClassLoader(),
				new Class[]{ Person.class }, handler );





		// 调用动态代理对象的 walk() 和 sayHello() 方法
		p.walk();
		p.sayHello( "孙悟空" );




	}

}