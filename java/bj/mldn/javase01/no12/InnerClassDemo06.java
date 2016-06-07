package bj.mldn.javase01.no12;

class Outer6 {

	private String name = "HELLO WORLD!!!";

	public void fun( final int temp ) {

		class Inner {

			public void print() {

				System.out.println( "temp = " + temp );
				System.out.println( "name = " + name );
			}
		}
		new Inner().print();
	}
}

public class InnerClassDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Outer6().fun( 30 );
	}

}
