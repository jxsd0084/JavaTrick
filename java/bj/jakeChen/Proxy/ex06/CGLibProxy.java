package bj.jakeChen.Proxy.ex06;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
// CGLIB动态代理
public class CGLibProxy implements MethodInterceptor {

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

		CGLibProxy cgLibProxy = new CGLibProxy();
		Hello      helloProxy = cgLibProxy.getProxy( HelloImpl.class );
		helloProxy.say( "METAL GEAR SOLID" );
	}

}
