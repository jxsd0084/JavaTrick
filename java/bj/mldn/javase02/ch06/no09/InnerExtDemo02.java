package bj.mldn.javase02.ch06.no09;

interface A3 {    // 定义接口

	public void printA();    // 抽象方法

	abstract class B3 {    // 定义内部抽象类

		public abstract void printB();    // 定义抽象方法
	}
}

class X3 implements A3 {    // 实现接口

	public void printA() {

		System.out.println("HELLO --> A");
	}

	class Y3 extends B3 {    // 继承抽象类

		public void printB() {

			System.out.println("HELLO --> B");
		}
	}
}

public class InnerExtDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		A3.B3 b = new X3().new Y3();
		b.printB();
	}
}
