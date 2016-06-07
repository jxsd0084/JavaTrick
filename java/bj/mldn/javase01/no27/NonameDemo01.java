package bj.mldn.javase01.no27;

interface A1 {

	public void fun();
}

class B1 implements A1 {

	public void fun() {

		System.out.println( "Hello World!!!" );
	}
}

class X1 {

	public void fun1( A1 a ) {

		a.fun();
	}

	public void fun2() {

		this.fun1( new B1() );
	}
}

public class NonameDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new X1().fun2();
	}

}
