package bj.powernode.advance.Charpter04.test2;

public class TestStudent {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student stu = new Student();
		stu.setAge( 23 );
		stu.setName( "张三" );
		stu.setSchoolName( "清华大学" );

		stu.study( "CoreJava" );

		System.out.println( stu.toString() );

	}

}
