package bj.mldn.javase01.no21;

class A3 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B3 extends A3 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

public class PolDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A3 a = new A3();
		B3 b = (B3) a;

		b.fun2();

	}

}
