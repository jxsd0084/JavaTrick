package bj.mldn.javase01.no12;

class Outer5 {

	private String name = "HELLO WORLD!!!";

	public void fun() {

		class Inner {

			public void print() {

				System.out.println( "name = " + name );
			}
		}
		new Inner().print();
	}
}

public class InnerClassDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Outer5().fun();
	}

}
