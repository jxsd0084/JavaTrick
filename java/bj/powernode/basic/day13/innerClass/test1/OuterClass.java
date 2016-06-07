package bj.powernode.basic.day13.innerClass.test1;

/**
 * 静态成员内部类.
 */
public class OuterClass {  // 外部类(top_level).

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


	// 静态成员内部类
	public static class InnerClass { // 只能访问外部类静态的数据.

		// 静态成员内部类不能访问外部类的非静态的数据.

		// 静态方法
		public static void m3() {

			System.out.println( s1 );
			// System.out.println(s2);
			m1();
			// m2();
		}


		// 实例方法
		public void m4() {

			System.out.println( s1 );
			// System.out.println(s2);
			m1();
			// m2();
		}

	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 调用m3方法.
		InnerClass.m3();



		// 调用m4方法.
		InnerClass inner = new InnerClass();
		inner.m4();


	}


}

