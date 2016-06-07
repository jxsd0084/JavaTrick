package bj.powernode.advance.Charpter05.test2;

public class Student extends Person {

	private static String clsssName = "600班";

	static {
		Student.clsssName = "611班";
		System.out.println( "子类的静态初始化块" );
	}

	private int id;

	{
		id = 1;
		System.out.println( "子类的初始化块" );
	}

	public Student() {

		System.out.println( "子类的构造方法" );
	}

	// @Override
	public static void fun1() {

		System.out.println( "父类的fun1()方法" );
	}

}
