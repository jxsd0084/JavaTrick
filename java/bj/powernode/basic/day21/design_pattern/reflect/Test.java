package bj.powernode.basic.day21.design_pattern.reflect;

import java.lang.reflect.Method;

public class Test {

	/**
	 * 通过反射调用UserService中的login方法
	 */
	public static void main( String[] args ) throws Exception {

		Class c = Class.forName( "reflect.UserService" );  //类的基因信息

		Method loginMethod = c.getDeclaredMethod( "login", String.class, String.class );  //login方法的基因信息

		System.out.println( loginMethod.invoke( new UserService(), "admin", "123" ) );  //等价于   us.login("admin","123");
	}

}
