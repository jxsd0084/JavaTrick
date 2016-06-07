package bj.mldn.javase01.no21;

class A4 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B4 extends A4 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

class C4 extends A4 {

	public void fun1() {    // 将方法覆写了

		System.out.println("4、C类 --> public void fun1(){}");
	}

	public void fun4() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("5、C类 --> public void fun4(){}");
	}
}

public class PolDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		fun(new B4());

		fun(new C4());

	}

	public static void fun(B4 b) {

		b.fun2();

		b.fun3();

	}

	public static void fun(C4 c) {

		c.fun2();

		c.fun4();

	}

}
