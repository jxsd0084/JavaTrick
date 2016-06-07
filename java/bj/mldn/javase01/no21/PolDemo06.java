package bj.mldn.javase01.no21;

class A6 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B6 extends A6 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

class C6 extends A6 {

	public void fun1() {    // 将方法覆写了
		System.out.println("4、C类 --> public void fun1(){}");
	}

	public void fun4() {    // 此操作为子类自己定义的，父类中不存在
		System.out.println("5、C类 --> public void fun4(){}");
	}
}

public class PolDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		fun(new B6());

		fun(new C6());

	}

	public static void fun(A6 a) {

		a.fun2();
		B6 b = (B6) a;
		b.fun3();

	}

}
