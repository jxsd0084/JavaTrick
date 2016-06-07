package bj.mldn.javase01.no19;

abstract class A5 {

	private String name;

	public A5( String name ) {    // 构造方法
		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public abstract void fun();
}

class B5 extends A5 {    // 继承抽象类

	public B5( String name ) {

		super( name );
	}

	public void fun() {    // 覆写方法时需要注意访问控制权限
		System.out.println( super.getName() );
	}
}

public class AbstractDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		B5 b = new B5( "MLDN" );

		b.fun();

	}

}
