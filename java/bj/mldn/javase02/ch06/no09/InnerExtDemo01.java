package bj.mldn.javase02.ch06.no09;

abstract class A2 {    // 定义抽象类

	public abstract void printA();    // 抽象方法

	interface B2 {    // 定义内部接口

		public void printB();    // 定义抽象方法
	}
}

class X2 extends A2 {    // 继承抽象类

	public void printA() {

		System.out.println( "HELLO --> A" );
	}

	class Y2 implements B2 {    // 定义内部类实现内部接口

		public void printB() {

			System.out.println( "HELLO --> B" );
		}
	}
}

public class InnerExtDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		A2.B2 b = new X2().new Y2();
		b.printB();
	}
}
