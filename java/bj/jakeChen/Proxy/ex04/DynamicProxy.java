package bj.jakeChen.Proxy.ex04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/6/2.
 */
// 动态代理
public class DynamicProxy implements InvocationHandler {

	private Object target;

	public DynamicProxy( Object target ) {

		this.target = target;
	}

	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

		before();
		Object result = method.invoke( target, args );
		after();
		return result;
	}

	private void before() {

		System.out.println( "Before" );
	}

	private void after() {

		System.out.println( "After" );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Hello hello = new HelloImpl();

		DynamicProxy dynamicProxy = new DynamicProxy( hello );

		Hello helloProxy = (Hello) Proxy.newProxyInstance( hello.getClass().getClassLoader(),
		                                                   hello.getClass().getInterfaces(),
		                                                   dynamicProxy );
		helloProxy.say( "BIOHAZARD" );
	}

}
