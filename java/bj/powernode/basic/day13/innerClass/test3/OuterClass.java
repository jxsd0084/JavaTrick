package bj.powernode.basic.day13.innerClass.test3;

/**
 * 局部内部类
 */
public class OuterClass {

	// 静态成员变量
	private static String s1 = "hello1";

	// 非静态成员变量
	private String s2 = "hello2";

	// 静态方法
	public static void m1() {

		System.out.println( "OuterClass's static m1 method invoked!" );
	}

	// 实例方法
	public void m2() {

		System.out.println( "OuterClass's instance m2 method invoked!" );
	}


	// 实例方法  测试局部内部类
	public void m3( final int k ) {

		// private String s = "";

		final int i = 10;  // 值不能再改变.

		// 局部内部类没有访问修饰符.
		class InnerClass1 {

			public void m4() {
				// 访问局部变量.
				System.out.println( i ); // 局部内部类中的方法如果要访问方法中的局部变量,那么该局部变量必须是final的.
				System.out.println( k );

				System.out.println( s1 );
				System.out.println( s2 );
				m1();
				m2();

			}

		}

		new InnerClass1().m4();

	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		OuterClass outer = new OuterClass();

		outer.m3( 123 );

	}

}















