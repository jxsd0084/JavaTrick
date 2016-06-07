package bj.mldn.javase01.no23;

interface A {

	public void fun();
}

class B implements A {

	public void fun() {

		System.out.println("Hello");
	}
}

public class InterPolDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A a = new B();    // 为接口实例化

		a.fun();

	}

}
