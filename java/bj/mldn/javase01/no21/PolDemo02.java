package bj.mldn.javase01.no21;

class A2 {

	public void fun1() {

		System.out.println("1、A类 --> public void fun1(){}");
	}

	public void fun2() {

		this.fun1();
	}
}

class B2 extends A2 {

	public void fun1() {    // 将方法覆写了

		System.out.println("2、B类 --> public void fun1(){}");
	}

	public void fun3() {    // 此操作为子类自己定义的，父类中不存在

		System.out.println("3、B类 --> public void fun3(){}");
	}
}

public class PolDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		A2 a = new B2();    // 发生向上转型关系，子类实例 --> 父类实例
		B2 b = (B2) a;      // 发生向下转型关系，强制

		b.fun3();
		b.fun2();

	}

}
