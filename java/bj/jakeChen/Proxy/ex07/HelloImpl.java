package bj.jakeChen.Proxy.ex07;

/**
 * Created by Administrator on 2016/6/2.
 */
// 使用 单例模式 重构CGLIB动态代理
public class HelloImpl implements Hello {

	@Override
	public void say( String name ) {

		System.out.println( "Hello ! " + name );
	}

}
