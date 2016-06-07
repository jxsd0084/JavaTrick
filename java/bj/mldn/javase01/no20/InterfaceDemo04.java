package bj.mldn.javase01.no20;

interface A4 {

	public void printA();
}

interface B4 {

	public void printB();
}

abstract class C4 {

	public abstract void printC();
}

class X4 extends C4 implements A4, B4 {

	public void printA() {

	}

	public void printB() {

	}

	public void printC() {

	}
}

public class InterfaceDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

//		B4 b = new B4();
		/*
		b.print();
		b.fun();
		b.funA();
		*/
	}
}
