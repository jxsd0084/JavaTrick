package bj.mldn.javase01.no19;

abstract class A4 {

	public A4() {    // 构造方法

		System.out.println( "*************************" );
	}

	public abstract void fun();
}

class B4 extends A4 {    // 继承抽象类

	public B4() {

		super();
		System.out.println( "=========================" );
	}

	public void fun() {    // 覆写方法时需要注意访问控制权限
		System.out.println( "Hello World!!!" );
	}
}

public class AbstractDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B4 b = new B4();

	}

}
