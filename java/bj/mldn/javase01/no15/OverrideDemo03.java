package bj.mldn.javase01.no15;

class A6 {

	private void fun() {

		System.out.println( "A类中定义的方法。" );
	}

	public void print() {

		this.fun();        // 调用fun()方法
	}
}

class B6 extends A6 {

	public void fun() {    // 此方法实际上属于新建的一个方法

		System.out.println( "B类中定义的方法。" );
	}
}

public class OverrideDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B6 b = new B6();

		b.print();

	}

}
