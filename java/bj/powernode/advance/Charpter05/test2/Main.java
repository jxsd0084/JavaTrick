package bj.powernode.advance.Charpter05.test2;

public class Main {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Person p1 = new Person( 22, "张二" );
		System.out.println( "====================" + p1 );




		Person p2 = new Person( 21, "张一" );
		Person.maxAge = 150;

		System.out.println( "====================" + p1 );
		System.out.println( "====================" + p2 );




		Person p3 = new Person( 23, "张三" );
		Person.setMaxAge( 180 );
		System.out.println( "====================" + p1 );
		System.out.println( "====================" + p2 );
		System.out.println( "====================" + p3 );


		Person.maxAge = 140;
		System.out.println( Person.getMaxAge() );
		Student stu = new Student();




	}


}
