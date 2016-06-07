package bj.mldn.javase02.ch06.no07;

class A3 {                    // 定义类A

	public void fun1() {        // 定义fun1()方法
		System.out.println( "A --> public void fun1(){}" );
	}

	public void fun2() {

		this.fun1();        // 调用fun1()方法
	}
}

class B3 extends A3 {

	public void fun1() {        // 此方法被子类覆写了
		System.out.println( "B --> public void fun1(){}" );
	}

	public void fun3() {

		System.out.println( "B --> public void fun3(){}" );
	}
}

public class PolDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String asrgs[] ) {

		A3 a = new A3();            // 实例化了一个父类对象
		B3 b = (B3) a;        // 发生了向下转型关系
		b.fun1();
		b.fun2();
		b.fun3();
	}
}
