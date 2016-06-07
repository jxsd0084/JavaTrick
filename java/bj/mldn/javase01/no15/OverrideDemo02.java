package bj.mldn.javase01.no15;

class A5 {

	public void fun() {

		System.out.println( "A类中定义的方法。" );
	}
}

class B5 extends A5 {

	public void fun() {    // 称为方法覆写

		System.out.println( "B类中定义的方法。" );
	}
}

public class OverrideDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B5 b = new B5();

		b.fun();

	}

}
