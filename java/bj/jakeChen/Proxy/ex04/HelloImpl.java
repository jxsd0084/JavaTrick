package bj.jakeChen.Proxy.ex04;

/**
 * Created by Administrator on 2016/6/2.
 */
// 动态代理
public class HelloImpl implements Hello {

	@Override
	public void say( String name ) {

		System.out.println( "Hello ! " + name );
	}

}
