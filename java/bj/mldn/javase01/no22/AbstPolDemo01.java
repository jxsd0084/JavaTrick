package bj.mldn.javase01.no22;

abstract class A1 {

	public abstract void fun();
}

class B1 extends A1 {

	public void fun() {

		System.out.println("Hello");
	}
}

public class AbstPolDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A1 a = new B1();

		a.fun();

	}

}
