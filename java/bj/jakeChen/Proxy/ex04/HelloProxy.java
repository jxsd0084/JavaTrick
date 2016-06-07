package bj.jakeChen.Proxy.ex04;

/**
 * Created by Administrator on 2016/6/2.
 */
// 动态代理
public class HelloProxy implements Hello {

	private Hello hello;

	public HelloProxy() {

		this.hello = new HelloImpl();
	}

	@Override
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

		Hello proxy = new HelloProxy();
		proxy.say( "FFXV" );
	}

}
