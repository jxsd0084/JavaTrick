package bj.jakeChen.Proxy.ex03;

/**
 * Created by Administrator on 2016/6/2.
 */
// 静态代理 错误写法
public class HelloImpl implements Hello {

	@Override
	public void say( String name ) {

		System.out.println( "Hello ! " + name );
	}

}
