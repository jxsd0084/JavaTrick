package bj.mldn.javase01.no20;

interface A6 {

	public void printA();
}

interface B6 {

	public void printB();
}

interface Z6 extends A6, B6 {    // X接口同时继承了A和B两个接口

	public void printZ();
}

abstract class C6 {

	public abstract void printC();
}

class X6 extends C6 implements Z6 {

	public void printA() {

	}

	public void printB() {

	}

	public void printC() {

	}

	public void printZ() {

	}
}

public class InterfaceDemo06 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		/*
		B6 b = new B6();
		b.print();
		b.fun();
		b.funA();
		*/
	}
}
