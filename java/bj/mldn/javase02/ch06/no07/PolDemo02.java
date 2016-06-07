package bj.mldn.javase02.ch06.no07;

class A2 {                    // 定义类A

	public void fun1() {        // 定义fun1()方法
		System.out.println( "A --> public void fun1(){}" );
	}

	public void fun2() {

		this.fun1();        // 调用fun1()方法
	}
}

class B2 extends A2 {

	public void fun1() {        // 此方法被子类覆写了
		System.out.println( "B --> public void fun1(){}" );
	}

	public void fun3() {

		System.out.println( "B --> public void fun3(){}" );
	}
}

public class PolDemo02 {

	public static void main( String asrgs[] ) {

		A2 a = new B2();            // 向上转型关系
		B2 b = (B2) a;        // 发生了向下转型关系
		b.fun1();
		b.fun2();
		b.fun3();
	}
}
