package bj.powernode.basic.day13.innerClass.test2;

/**
 * 非静态成员内部类.
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


	// 非静态成员内部类.
	// 非静态成员内部类中不能出现 静态的数据.
	public class InnerClass {
		// private static String s3 = "hello3";
		// public static void m3(){} // 静态方法

		private String s4 = "hello4";

		// 实例方法
		public void m4() {

			System.out.println( s1 );
			System.out.println( s2 );
			m1();
			m2();
			System.out.println( "InnerClass's instance m4() invoked!" );
		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		OuterClass outer = new OuterClass();

		InnerClass inner = outer.new InnerClass();

		inner.m4();

	}

}
