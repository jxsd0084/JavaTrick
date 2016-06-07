package bj.jakeChen.AOP.ex05;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/2.
 */
// 前置增强类
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before( Method method, Object[] args, Object target ) throws Throwable {

		System.out.println( "Before" );
	}

}
