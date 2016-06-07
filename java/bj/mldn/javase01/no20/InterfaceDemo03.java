package bj.mldn.javase01.no20;

interface A3 {

	// public static final String INFO = "CHINA" ;
	String INFO = "CHINA";    // 全局常量

	// public abstract void print() ;
	void print();    // 抽象方法

	public void fun();    // 抽象方法
}

interface C3 {

	public void funA();
}

class B3 implements A3, C3 {    // 子类B实现了接口A

	public void print() {    // 实现抽象方法

		System.out.println("HELLO WORLD!!!");
	}

	public void fun() {

		System.out.println(INFO);    // 输出全局常量
	}

	public void funA() {

		System.out.println("信息：" + INFO);
	}
}

public class InterfaceDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		B3 b = new B3();

		b.print();

		b.fun();

		b.funA();

	}

}
