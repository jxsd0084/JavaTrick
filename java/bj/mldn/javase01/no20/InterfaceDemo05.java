package bj.mldn.javase01.no20;

interface A5 {

	public void printA();
}

interface B5 {

	public void printB();
}

abstract class C5 implements A5, B5 {

	public abstract void printC();
}

class X5 extends C5 {

	public void printA() {

	}

	public void printB() {

	}

	public void printC() {

	}
}

public class InterfaceDemo05 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		/*
		B5 b = new B5();
		b.print();
		b.fun();
		b.funA();
		*/
	}
}
