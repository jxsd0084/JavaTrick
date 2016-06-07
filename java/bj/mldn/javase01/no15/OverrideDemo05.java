package bj.mldn.javase01.no15;

class A8 {

	public String name = "HELLO";
}

class B8 extends A8 {

	public int name = 1;    // 此时属性覆盖了

	public void print() {

		System.out.println( "name = " + name );
	}
}

public class OverrideDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B8 b = new B8();

		b.print();

	}

}
