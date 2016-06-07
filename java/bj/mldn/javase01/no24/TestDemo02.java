package bj.mldn.javase01.no24;

interface A2 {

	public void fun();

	abstract class B {    // 内部抽象类

		public abstract void print();
	}
}

class X2 implements A2 {

	public void fun() {

		System.out.println("****************");
	}

	class Y extends B {

		public void print() {

			System.out.println("===================");
		}
	}

}

public class TestDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A2 a = new X2();
		a.fun();

		A2.B b = new X2().new Y();
		b.print();

	}

}