package bj.jakeChen.AOP.ex04;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
public class CGLibDynamicProxy implements MethodInterceptor {

	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

	private CGLibDynamicProxy() {

	}

	public static CGLibDynamicProxy getInstance() {

		return instance;
	}

	@SuppressWarnings("unchecked")
	public < T > T getProxy( Class< T > cls ) {

		return (T) Enhancer.create( cls, this );
	}

	@Override
	public Object intercept( Object o, Method method, Object[] objects, MethodProxy methodProxy ) throws Throwable {

		before();
		Object result = methodProxy.invokeSuper( o, objects );
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

		Greeting proxy = CGLibDynamicProxy.getInstance().getProxy( GreetingImpl.class );
		proxy.sayHello( "SILENT HILL2" );
	}

}
