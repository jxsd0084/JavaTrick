package bj.powernode.basic.day15.reflect;

/*

	如何在java语言中获得某个类的基因信息.
		获取类的基因信息的第一种方式:

			1.Class c = Class.forName("完整的类名");

				本质: 将指定的类加载到JVM中的过程.

*/
public class TestClass01 {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		try {

			// 第一种方式. Class c = Class.forName("完整的类名");

			String className = "Cat";

			Class catClass = Class.forName( className );    // 获取Cat类的基因信息.

			Class dogClass = Class.forName( "Dog" );        // 获取Dog类的基因信息.

			System.out.println( "Cat类的基因信息:" + catClass.toString() );
			System.out.println( "Dog类的基因信息:" + dogClass.toString() );





			// 完整的类名是带有包名的.
			Class dateClass = Class.forName( "java.util.Date" );

			System.out.println( "java.util.Date类的基因信息:" + dateClass.toString() );




			// 如果类名不存在
			Class stringClass = Class.forName( "java.lang.String" );

			System.out.println( "java.lang.String类的基因信息:" + stringClass.toString() );

			Class userClass = Class.forName( "User" );

			System.out.println( userClass );


		} catch ( ClassNotFoundException e ) {

			e.printStackTrace();
		}


	}

}

class Cat {

	// 静态语句块中的代码在 Cat类加载的时候执行.
	static {

		System.out.println( "Cat's static executing..." );

	}

	private String name;
	private int    age;


	// c.newInstance()方法默认调用了无参数构造方法.
	public Cat() {

	}

	// 有参数的构造方法将无参数的构造方法覆盖.
	public Cat( String name, int age ) {

		this.name = name;
		this.age = age;
	}


}


class Dog {

	static {
		System.out.println( "Dog's static executing..." );
	}

	private String name;
	private int    age;

}


class User {

	static {

		System.out.println( "User's static executing..." );
	}

}
