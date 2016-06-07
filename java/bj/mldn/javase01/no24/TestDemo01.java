package bj.mldn.javase01.no24;

abstract class A1 {

	public abstract void fun();

	interface B {    // 内部接口

		public void print();
	}
}

class X1 extends A1 {

	public void fun() {

		System.out.println("****************");
	}

	class Y implements B {

		public void print() {

			System.out.println("===================");
		}
	}

}

public class TestDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A1 a = new X1();
		a.fun();

		A1.B b = new X1().new Y();
		b.print();

	}

}