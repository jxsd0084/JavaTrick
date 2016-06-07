package bj.JavaSpecialForces.chapter03.fullgc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.net.URLClassLoader;

public class ClassPermGenFullGC {

	private static URLClassLoader parentClassLoader;

	static {
		parentClassLoader = (URLClassLoader) ClassPermGenFullGC.class.getClassLoader();
	}

	public static Object createProxy( Class< ? > targetClass ) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass( targetClass );
		enhancer.setClassLoader( new URLClassLoader( parentClassLoader.getURLs(), parentClassLoader ) );
		enhancer.setUseCache( false );
		enhancer.setCallback( new MethodInterceptor() {
			public Object intercept( Object object, Method method, Object[] args, MethodProxy methodProxy ) throws Throwable {
				return methodProxy.invokeSuper( object, args );
			}
		} );
		return enhancer.create();
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		while ( true ) {

			createProxy( ClassPermGenFullGC.class );
		}

	}

}
