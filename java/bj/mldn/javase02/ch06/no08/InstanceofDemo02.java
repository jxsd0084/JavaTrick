package bj.mldn.javase02.ch06.no08;

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

class C2 extends A2 {

	public void fun1() {        // 此方法被子类覆写了
		System.out.println( "C --> public void fun1(){}" );
	}

	public void fun5() {

		System.out.println( "C --> public void fun5(){}" );
	}
}

public class InstanceofDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String asrgs[] ) {

		fun( new B2() );
		fun( new C2() );
	}

	public static void fun( A2 a ) {

		a.fun1();
		if ( a instanceof B2 ) {
			B2 b = (B2) a;
			b.fun3();
		}
		if ( a instanceof C2 ) {
			C2 c = (C2) a;
			c.fun5();
		}
	}
}
