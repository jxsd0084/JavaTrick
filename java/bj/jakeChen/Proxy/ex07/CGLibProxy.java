package bj.jakeChen.Proxy.ex07;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
// 使用 单例模式 重构CGLIB动态代理
public class CGLibProxy implements MethodInterceptor {

	private static CGLibProxy instance = new CGLibProxy();

	private CGLibProxy() {

	}

	public static CGLibProxy getInstance() {

		return instance;
	}

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

		// 之前的写法
/*		CGLibProxy cgLibProxy = new CGLibProxy();
		Hello      helloProxy = cgLibProxy.getProxy( HelloImpl.class );*/

		// 使用 单例模式 重构之后的写法
		Hello helloProxy = CGLibProxy.getInstance().getProxy( HelloImpl.class );
		helloProxy.say( "METAL GEAR SOLID" );
	}

}
