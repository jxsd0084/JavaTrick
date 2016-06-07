package bj.mldn.javase02.ch05.no15;

class Outer5 {        // 定义外部类

	private String info = "hello world";    // 定义外部类的私有属性

	public void fun( final int temp ) {     // 定义外部类的方法
		// 在方法中定义的内部类
		class Inner {

			public void print() {           // 定义内部类的方法
				System.out.println( "类中的属性：" + info );        // 直接访问外部类的私有属性
				System.out.println( "方法中的参数：" + temp );
			}
		}
		;
		new Inner().print();                // 通过内部类的实例化对象调用方法
	}
};

public class InnerClassDemo05 {

	public static void main( String args[] ) {

		// 调用外部类的方法
		new Outer5().fun( 30 );
	}

}
