package bj.mldn.javase02.ch06.no09;

interface A4 {    // 定义抽象类A

	public abstract void print();    // 定义抽象方法print()
}

class B4 implements A4 {    // 定义子类，继承抽象类

	public void print() {        // 覆写抽象方法
		System.out.println( "Hello World!!!" );
	}
}

public class InterfaceCaseDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		A4 a = new B4();        // 通过子类为抽象类实例化
		a.print();
	}
}
