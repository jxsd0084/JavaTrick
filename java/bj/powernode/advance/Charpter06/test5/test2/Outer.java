
// 静态内部类
package bj.powernode.advance.Charpter06.test5.test2;

/**
 * 本例主题:静态内部类
 * 关键字:
 * Outer o = new Outer();
 * Outer.Inner inner = new Outer.Inner(100);
 */

// 外部类Outer
public class Outer {

	// 私有静态属性
	private static int index = 1000;
	// 私有属性
	private int index2;

	// 私有静态方法
	private static void f2() {

		System.out.println( "外部类私有的方法被调用: index=" + Outer.index );
	}

	// 对象方法
	public void f3() {

		System.out.println( "对象的私有属性:index2=" + index2 );
	}

	// 静态内部类,在创建静态内部类的时候,不需要有外部类的对象
	static class Inner {

		// 成员内部类中不能有静态的变量,静态内部类中可以有静态变量(废话)
		private static int index;

		// 静态内部类构造方法
		public Inner( int index ) {
			//注意:处不能有this,没有对象
			Inner.index = index;
		}

		// 在静态内部类中只能访问外部类私有静态属性和私有静态方法 !
		public void f1() {

			System.out.println( "静态内部类的方法被调用! index1=" + Inner.index );
			// 访问外部类的私有静态方法
			f2();
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Outer outer = new Outer();
		outer.index2 = 444;
		outer.f3();



		// 注意:创建静态内部类对象的过程
		Inner inner = new Inner( 100 );
		// 调用静态内部类的f1方法
		inner.f1();



	}

}
