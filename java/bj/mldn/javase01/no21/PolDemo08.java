package bj.mldn.javase01.no21;

class A8 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B8 extends A8 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

class C8 extends A8 {

	public void fun1() {    // 将方法覆写了

		System.out.println("4、C类 --> public void fun1(){}");
	}

	public void fun4() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("5、C类 --> public void fun4(){}");
	}
}

public class PolDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		fun(new B8());

		fun(new C8());

	}

	public static void fun(A8 a) {

		a.fun2();
		if (a instanceof B8) {

			B8 b = (B8) a;
			b.fun3();
		}

		if (a instanceof C8) {

			C8 c = (C8) a;
			c.fun4();
		}
	}
}
