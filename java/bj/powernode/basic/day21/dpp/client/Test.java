package bj.powernode.basic.day21.dpp.client;

import bj.powernode.basic.day21.dpp.common.LogMethodExeTimeProxy;
import bj.powernode.basic.day21.dpp.service.ProductService;
import bj.powernode.basic.day21.dpp.service.UserService;

public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		// 测试1
		LogMethodExeTimeProxy timerProxy = new LogMethodExeTimeProxy( new UserService() );

		Object exeResult = timerProxy.invoke( "login", new Class[]{ String.class, String.class }, new Object[]{ "admin", "123" } );

		System.out.println( exeResult );







		// 测试2
		LogMethodExeTimeProxy timerProxy2 = new LogMethodExeTimeProxy( new ProductService() );

		timerProxy2.invoke( "clearCart", null, null );







		// 测试3
		LogMethodExeTimeProxy timerProxy3 = new LogMethodExeTimeProxy( new String( "hello,world" ) );

		String[] strs = (String[]) timerProxy3.invoke( "split", new Class[]{ String.class }, new Object[]{ "," } );

		for ( String s : strs ) {

			System.out.println( s );
		}

	}

}
