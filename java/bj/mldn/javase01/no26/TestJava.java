package bj.mldn.javase01.no26;

abstract class A {

	public A() {

		this.print();
	}

	public abstract void print();
}

class B extends A {

	private int x = 100;

	public B( int x ) {

		this.x = x;
	}

	public void print() {

		System.out.println( "x = " + x );
	}
}

public class TestJava {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		A a = new B( 10 );
	}

}
