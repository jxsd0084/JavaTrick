package bj.mldn.javase01.no12;

class Outer3 {

	private String name = "HELLO WORLD!!!";

	class Inner {

		public void print() {

			System.out.println( "name = " + name );
		}
	}

}

public class InnerClassDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Outer3       out = new Outer3();       // 外部类实例

		Outer3.Inner in  = out.new Inner();    // 实例化内部类对象

		in.print();

	}

}
