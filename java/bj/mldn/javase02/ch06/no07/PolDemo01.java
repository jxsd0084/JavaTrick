package bj.mldn.javase02.ch06.no07;

class A {                    // 定义类A

	public void fun1() {        // 定义fun1()方法
		System.out.println( "A --> public void fun1(){}" );
	}

	public void fun2() {

		this.fun1();        // 调用fun1()方法
	}
}

class B extends A {

	public void fun1() {        // 此方法被子类覆写了
		System.out.println( "B --> public void fun1(){}" );
	}

	public void fun3() {

		System.out.println( "B --> public void fun3(){}" );
	}
}

public class PolDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String asrgs[] ) {

		B b = new B();        // 实例化子类对象
		A a = b;            // 向上转型关系
		a.fun1();            // 此方法被子类覆写过
//		a.fun3();
	}
}
