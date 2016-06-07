package bj.jakeChen.Proxy.ex02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chenlong on 2016/5/23.
 */
public class TraceHandler implements InvocationHandler {

	private Object target; // 以真实角色作为代理角色的属性

	// 构造器
	public TraceHandler( Object target ) {
		this.target = target;
	}

	/*
	 * 通过反射机制动态执行真实角色的每一个方法
    */
	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
		try {

			System.out.println( "被拦截的方法: " + method.getName() );
			System.out.println( "预处理..." );

			return method.invoke( target, args );

		} catch ( Exception e ) {
			return null;

		} finally {
			System.out.println( "善后处理..." );

		}

	}

}
