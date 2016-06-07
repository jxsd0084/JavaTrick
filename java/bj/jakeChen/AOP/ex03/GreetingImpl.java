package bj.jakeChen.AOP.ex03;

/**
 * Created by Administrator on 2016/6/2.
 */
public class GreetingImpl implements Greeting {

	@Override
	public void sayHello( String name ) {

//		before();
		System.out.println( "Hello ! " + name );
//		after();
	}

/*	private void before() {

		System.out.println( "Before" );
	}

	private void after() {

		System.out.println( "After" );
	}*/

}


/*

缺点:

	before() 和 after() 方法写死在sayHello()方法里面了, "硬编码"


重构, 三种解决方案:

1. 静态代理
2. JDK动态代理
3. CGLib动态代理

*/