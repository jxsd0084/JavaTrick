package bj.mldn.javase02.ch06.no06;

interface A6 {        // 定义接口A

	public String AUTHOR = "李兴华";    // 全局常量

	public void printA();    // 抽象方法
}

interface B6 {

	public void printB();
}

interface C6 extends A6, B6 {

	public void printC();
}

class X6 implements C6 {    // X类线继承B类

	public void printA() {

		System.out.println( "A、Hello World!!!" );
	}

	public void printB() {

		System.out.println( "B、Hello MLDN" );
	}

	public void printC() {

		System.out.println( "C、Hello LXH" );
	}
}

public class InterfaceDemo06 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		X6 x = new X6();    // 实例化子类对象
		x.printA();
		x.printB();
		x.printC();
	}
}
