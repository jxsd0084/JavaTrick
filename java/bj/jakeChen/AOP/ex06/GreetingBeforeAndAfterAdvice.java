package bj.jakeChen.AOP.ex06;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning( Object returnValue, Method method, Object[] args, Object target ) throws Throwable {

		System.out.println( "After" );
	}

	@Override
	public void before( Method method, Object[] args, Object target ) throws Throwable {

		System.out.println( "Before" );
	}

}
