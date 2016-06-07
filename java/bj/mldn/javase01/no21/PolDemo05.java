package bj.mldn.javase01.no21;

class A5 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B5 extends A5 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

class C5 extends A5 {

	public void fun1() {    // 将方法覆写了

		System.out.println("4、C类 --> public void fun1(){}");
	}

	public void fun4() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("5、C类 --> public void fun4(){}");
	}
}

public class PolDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		fun(new B5());

		fun(new C5());

	}

	public static void fun(A5 a) {

		a.fun2();
	}

}
