package bj.powernode.basic.day07.exercise.exercise03.exception02;

public class Test {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//1.创建学生对象
		Student s1 = new Student();

		try {

			s1.printName( new Object() );

		} catch ( MustStringArgumentException msae ) {

			// msae.printStackTrace();
			System.out.println( msae.getMessage() );
		}

		System.out.println( "hello world" );

	}

}
