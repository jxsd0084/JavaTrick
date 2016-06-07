package bj.jakeChen.AOP.ex02;

import bj.jakeChen.AOP.ex01.Greeting;

/**
 * Created by Administrator on 2016/6/2.
 */
public class GreetingProxy implements Greeting {

	private GreetingImpl greetingImpl;

	public GreetingProxy( GreetingImpl greetingImpl ) {

		this.greetingImpl = greetingImpl;
	}

	@Override
	public void sayHello( String name ) {

		before();
		greetingImpl.sayHello( name );
		after();
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

		Greeting proxy = new GreetingProxy( new GreetingImpl() );
		proxy.sayHello( "Mass Effert3" );

	}

}

/*

缺点:

	before() 和 after() 方法写死在sayHello()方法里面了, "硬编码"


重构, 三种解决方案:

1. 静态代理
2. JDK动态代理
3. CGLib动态代理

*/
