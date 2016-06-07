package bj.mldn.javase02.ch06.no09;

abstract class A1 {    // 定义抽象类A

	public abstract void print();    // 定义抽象方法print()
}

class B1 extends A1 {    // 定义子类，继承抽象类

	public void print() {        // 覆写抽象方法
		System.out.println( "Hello World!!!" );
	}
}

public class AbstractCaseDemo01 {

	public static void main( String args[] ) {

		A1 a = new B1();        // 通过子类为抽象类实例化
		a.print();
	}
}
