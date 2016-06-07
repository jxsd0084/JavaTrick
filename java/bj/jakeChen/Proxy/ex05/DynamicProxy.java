package bj.jakeChen.Proxy.ex05;

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

	// 重构DynamicProxy类, 避免到处都是Proxy.newProxyInstance
	@SuppressWarnings("unchecked")
	public < T > T getProxy() {

		return (T) Proxy.newProxyInstance( target.getClass().getClassLoader(),
		                                   target.getClass().getInterfaces(),
		                                   this );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Hello hello = new HelloImpl();


/*
		// 之前的调用方式, 把Proxy.newProxyInstance给暴露出来了.
		DynamicProxy dynamicProxy = new DynamicProxy( hello );
		Hello helloProxy = (Hello) Proxy.newProxyInstance( hello.getClass().getClassLoader(),
		                                                   hello.getClass().getInterfaces(),
		                                                   dynamicProxy );*/

		// 代码重构之后的调用方式
		DynamicProxy dynamicProxy = new DynamicProxy( hello );
		Hello        helloProxy   = dynamicProxy.getProxy();
		helloProxy.say( "BIOHAZARD" );

	}

}
