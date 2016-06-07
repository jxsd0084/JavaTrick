package bj.mldn.javase02.ch06.no05;

abstract class A3 {    // 是定义了一个抽象类

	public A3() {

		System.out.println( "A、抽象类中的构造方法。" );
	}
}

class B3 extends A3 {    // 继承抽象类，因为B是普通类，所以必须覆写全部抽象方法

	public B3() {

		super();
		System.out.println( "B、子类中的构造方法。" );
	}
}

public class AbstractDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		B3 b = new B3();
	}

}
