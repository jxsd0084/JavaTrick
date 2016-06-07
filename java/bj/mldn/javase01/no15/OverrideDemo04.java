package bj.mldn.javase01.no15;

class A7 {

	public void fun() {

		System.out.println( "A类中定义的方法。" );
	}
}

class B7 extends A7 {

	public void fun() {    // 此方法实际上属于新建的一个方法

		super.fun();    // 调用父类中的fun()方法
		System.out.println( "B类中定义的方法。" );
	}
}

public class OverrideDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B7 b = new B7();

		b.fun();

	}

}
