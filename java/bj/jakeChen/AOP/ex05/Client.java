package bj.jakeChen.AOP.ex05;


import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Client {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		ProxyFactory proxyFactory = new ProxyFactory();         // 创建代理工厂
		proxyFactory.setTarget( new GreetingImpl() );           // 目标类对象
		proxyFactory.addAdvice( new GreetingBeforeAdvice() );   // 前置增强类
		proxyFactory.addAdvice( new GreetingAfterAdvice() );    // 后置增强类

		Greeting proxy = (Greeting) proxyFactory.getProxy();
		proxy.sayHello( "Terminator 2" );
	}

}
