package bj.mldn.javase01.no12;

class Outer4 {

	private static String name = "HELLO WORLD!!!";

	static class Inner {

		public void print() {

			System.out.println( "name = " + name );
		}
	}

}

public class InnerClassDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Outer4.Inner in = new Outer4.Inner();    // 实例化内部类对象

		in.print();

	}

}
