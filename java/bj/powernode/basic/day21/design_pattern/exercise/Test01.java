package bj.powernode.basic.day21.design_pattern.exercise;

public class Test01 {

	public static void main( String[] args ) {

		UserService us = new UserService();


		//记录 UserService对象的login方法耗时
		long begin = System.currentTimeMillis();

		us.login( "admin", "123" );

		long end = System.currentTimeMillis();


		System.out.println( "login方法执行耗时=" + ( end - begin ) + "ms" );


		//记录UserService对象的disable方法耗时

		long begin1 = System.currentTimeMillis();

		us.disable();

		long end1 = System.currentTimeMillis();


		System.out.println( "disable方法执行耗时=" + ( end1 - begin1 ) + "ms" );
	}

}
