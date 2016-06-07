package bj.mldn.javase01.no09;

class A {

	private B b = null;

	public void fun() {

		this.b = new B( this );
		this.b.fun();
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}
}

class B {

	private A a = null;

	public B( A a ) {

		this.a = a;
	}

	public void fun() {

		this.a.print();
	}
}

public class ThisDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new A().fun();
	}

}
