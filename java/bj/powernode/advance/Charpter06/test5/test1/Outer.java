//成员内部类
package bj.powernode.advance.Charpter06.test5.test1;

/**
 * 本例主题：成员内部类
 * 关键字：
 * Outer outer = new Outer(200);
 * Outer.Inner inner = outer.new Inner(100);
 * inner.f1();
 * outer.f1();
 * outer.fun1();
 */

// 外部类
public class Outer {

	// 成员变量,又称为实例变量(只有有了一个实例之后,才会有这个属性)
	private int index;

	// 有参构造,参数:int类型 index
	public Outer( int index ) {

		this.index = index;
	}

	// 普通方法f1,方法中调用fun1()方法
	public void f1() {

		fun1();
	}

	// 普通方法fun1
	private void fun1() {

		System.out.println( "外部类私有的方法: index=" + index );
	}

	// 成员内部类,类似于成员变量,只有有了一个外部类的对象之后,通过该该外部类的对象
	// 才能创建一个内部类的对象
	class Inner {

		// 内部类属性int类型 index
		private int index;

		// 成员内部类中不能有静态的变量
		// private static int index1;

		// 成员内部类中可以有构造方法(需要先创建外部类的对象再来创建内部类的对象)
		public Inner( int index ) {

			this.index = index;
		}

		public void f1() {

			System.out.println( "内部类的方法被调用: index = " + index );
			System.out.println( "内部类中访问外部类私有的属性: index = " + Outer.this.index );

			// 内部类的第一个作用:可以访问外部类私有的属性或私有的方法
			// fun1();
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建外部类对象outer
		Outer outer = new Outer( 200 );

		// 通过外部类对象创建内部类对象inner
		Inner inner = outer.new Inner( 100 );
		// 通过inner调用内部类方法f1
		inner.f1();

		// 通过outer对象调用外部类f1方法
		outer.f1();

		// 通过outer对象调用外部类fun1方法
		outer.fun1();

	}

}
