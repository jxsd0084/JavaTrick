package bj.mldn.javase02.ch06.no13;

interface A {

	public void printInfo();
}

class B implements A {    // 实现接口

	public void printInfo() {

		System.out.println("Hello World!!!");
	}
}

class X {

	public void fun1() {

		this.fun2(new B());
	}

	public void fun2(A a) {

		a.printInfo();
	}
}

public class NoInnerClassDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		new X().fun1();        // 实例化X类的对象，并调用fun1()方法
	}
}
