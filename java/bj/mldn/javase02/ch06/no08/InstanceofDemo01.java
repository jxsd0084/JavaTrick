package bj.mldn.javase02.ch06.no08;

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

public class InstanceofDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String asrgs[] ) {
		A a1 = new B();        // 通过向上转型实例化对象
		System.out.println( "A a1 = new B()：" + ( a1 instanceof A ) );
		System.out.println( "A a1 = new B()：" + ( a1 instanceof B ) );
		A a2 = new A();        // 通过向上转型实例化对象
		System.out.println( "A a2 = new B()：" + ( a2 instanceof A ) );
		System.out.println( "A a2 = new B()：" + ( a2 instanceof B ) );
	}
}
