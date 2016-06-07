package bj.jakeChen.AOP.ex07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2016/6/2.
 */
public class GreetingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke( MethodInvocation invocation ) throws Throwable {

		before();
		Object result = invocation.proceed();
		after();
		return result;
	}

	private void before() {

		System.out.println( "Before" );
	}

	private void after() {

		System.out.println( "After" );
	}

}
