package bj.mldn.javase01.no27;

interface A2 {

	public void fun();
}

class X2 {

	public void fun1( A2 a ) {

		a.fun();
	}

	public void fun2() {

		this.fun1( new A2() {

			public void fun() {

				System.out.println( "Hello World!!!" );
			}
		} );
	}
}

public class NonameDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new X2().fun2();
	}

}
