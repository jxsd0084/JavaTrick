package bj.jakeChen.Proxy.ex03;

/**
 * Created by Administrator on 2016/6/2.
 */
// 静态代理 错误写法
public class HelloProxy {

	private Hello hello;

	public HelloProxy( Hello hello ) {

		this.hello = hello;
	}

	public void say( String name ) {

		before();
		hello.say( name );
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

		HelloProxy proxy = new HelloProxy( new HelloImpl() );
		proxy.say( "Death" );
	}

}
