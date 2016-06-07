package bj.powernode.advance.Charpter04.test1;

public class Test1 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		// 基本类型在传递的时候,传递的是基本类型的值,改变一个变量的值,不会影响其他的变量的值
		int i = 10;
		int j = i;
		j = 20;
		System.out.println( "i=" + i );
		System.out.println( "j=" + j );

		int i2 = 10;
		i2 = change( i2 );
		System.out.println( "i=" + i2 );


		// 引用类型在传递的时候,传递的是对象的地址,改变一个变量的值,会影响另外一个变量
		Student s1 = new Student( "张一", 21 );
		Student s2 = s1;

		s2.setAge( 23 );
		s2.setName( "张三" );

		System.out.println( s1.toString() );
		System.out.println( s2.toString() );

		Student s3 = new Student( "张一", 21 );
		change( s3 );
		System.out.println( s3.toString() );


		Student s4 = new Student( "张一", 21 );
		s4 = null;
		change( s4 );
		System.out.println( s4.toString() );

	}

	public static void change( Student stu ) {

		stu.setAge( 24 );
		stu.setName( "张四" );
		stu = null;
	}

	public static int change( int j ) {

		j = 1000;
		return j;
	}

}
