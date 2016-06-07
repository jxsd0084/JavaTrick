package bj.mldn.javase01.no21;

class A7 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B7 extends A7 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

class C7 extends A7 {

	public void fun1() {    // 将方法覆写了

		System.out.println("4、C类 --> public void fun1(){}");
	}

	public void fun4() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("5、C类 --> public void fun4(){}");
	}
}

public class PolDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A7 a = new B7();

		System.out.println(a instanceof A7);
		System.out.println(a instanceof B7);
		System.out.println(a instanceof C7);

	}

}
