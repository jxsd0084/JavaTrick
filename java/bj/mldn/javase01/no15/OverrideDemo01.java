package bj.mldn.javase01.no15;

class A4 {

	public void fun() {

		System.out.println( "A类中定义的方法。" );
	}
}

class B4 extends A4 {

	public void fun() {    // 称为方法覆写
		System.out.println( "B类中定义的方法。" );
	}
}

public class OverrideDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B4 b = new B4();

		b.fun();

	}

}
