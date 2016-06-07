package bj.jakeChen.AOP.ex07;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
// 后置增强类
public class GreetingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning( Object returnValue, Method method, Object[] args, Object target ) throws Throwable {

		System.out.println( "After" );
	}

}
