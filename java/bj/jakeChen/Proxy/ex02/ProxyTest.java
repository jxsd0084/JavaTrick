package bj.jakeChen.Proxy.ex02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chenlong on 2016/5/23.
 */
public class ProxyTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 真实对象（即被代理对象）
		final IAnimal animal = new Cat();

		// 为真实对象制定一个调用处理器
		InvocationHandler handler = new TraceHandler( animal );

		// 获得真实对象(animal)的一个代理类 ★★★★★
		Object proxyObj = Proxy.newProxyInstance(
				animal.getClass().getClassLoader(), // 真实对象的类加载器
				animal.getClass().getInterfaces(),  // 真实对象实现的所有接口
				handler                             // 真实对象的处理器
		);

		if ( proxyObj instanceof IAnimal ) {
			System.out.println( "the proxyObj is an animal!" );
			IAnimal animalProxy = (IAnimal) proxyObj;
		} else {
			System.out.println( "the proxyObj isn't an animal!" );
		}

	}

}

/*

URL:    http://www.blogjava.net/thisliy/archive/2009/10/24/299621.html

*/
