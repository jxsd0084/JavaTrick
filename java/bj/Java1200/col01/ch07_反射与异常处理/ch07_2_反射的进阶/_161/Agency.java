package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._161;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agency implements InvocationHandler {

	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

		System.out.println( "代理人员在卖房子" );// 用来处理代理类
		return null;
	}
}
