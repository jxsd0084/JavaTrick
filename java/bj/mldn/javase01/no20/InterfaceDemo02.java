package bj.mldn.javase01.no20;

interface A2 {

	// public static final String INFO = "CHINA" ;
	String INFO = "CHINA";    // 全局常量

	// public abstract void print() ;
	void print();           // 抽象方法

	public void fun();    // 抽象方法
}

class B2 implements A2 {    // 子类B实现了接口A

	public void print() {    // 实现抽象方法
		System.out.println("HELLO WORLD!!!");
	}

	public void fun() {

		System.out.println(INFO);    // 输出全局常量
	}
}

public class InterfaceDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		B2 b = new B2();

		b.print();

		b.fun();

	}

}
