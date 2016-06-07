package bj.powernode.basic.day21.design_pattern.dynamic_agent;

public class Test {

	/**
	 * 测试动态代理
	 */
	public static void main( String[] args ) {


		//没用代理模式之前的执行
		Target t = new Target();
		t.method( "abcdef", "defghi" );


		//创建代理对象
		DynamicAgent da = new DynamicAgent( new Target() );

		//执行代理方法
		Object obj = da.invoke( "method", new Class[]{ String.class, String.class }, new Object[]{ "abcdef", "defghi" } );


		System.out.println( obj ); //false


		//创建代理对象
		DynamicAgent da2 = new DynamicAgent( new UserService() );

		//执行代理方法
		Object obj2 = da2.invoke( "login", new Class[]{ String.class, String.class }, new Object[]{ "admin", "123" } );


		System.out.println( obj2 ); //true

	}

}
