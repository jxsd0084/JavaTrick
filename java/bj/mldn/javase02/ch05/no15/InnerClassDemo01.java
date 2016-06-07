package bj.mldn.javase02.ch05.no15;

// 定义外部类
class Outer1 {

	private String info = "hello world";    // 定义外部类的私有属性

	class Inner {                           // 定义内部类

		public void print() {               // 定义内部类的方法
			System.out.println( info );     // 直接访问外部类的私有属性
		}
	}

	public void fun() {                     // 定义外部类的方法
		new Inner().print();                // 通过内部类的实例化对象调用方法
	}
}

public class InnerClassDemo01 {

	public static void main( String args[] ) {

		// 调用外部类的fun()方法
		new Outer1().fun();
	}

}
