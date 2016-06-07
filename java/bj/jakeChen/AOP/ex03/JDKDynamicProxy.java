package bj.jakeChen.AOP.ex03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/6/2.
 */
public class JDKDynamicProxy implements InvocationHandler {

	private Object target;

	public JDKDynamicProxy( Object target ) {

		this.target = target;
	}

	@SuppressWarnings("unchecked")
	public < T > T getProxy() {

		return (T) Proxy.newProxyInstance( target.getClass().getClassLoader(),
		                                   target.getClass().getInterfaces(),
		                                   this );
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

		Greeting proxy = new JDKDynamicProxy( new GreetingImpl() ).getProxy();
		proxy.sayHello( "ACE COMBAT4" );
	}

}
