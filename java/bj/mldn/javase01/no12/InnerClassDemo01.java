package bj.mldn.javase01.no12;

class Outer1 {

	private String name = "HELLO WORLD!!!";

	class Inner {

		public void print() {

			System.out.println( "name = " + name );
		}
	}

	public void fun() {

		new Inner().print();    // 打印信息
	}

}

public class InnerClassDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Outer1().fun();
	}
}
