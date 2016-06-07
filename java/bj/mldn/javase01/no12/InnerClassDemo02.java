package bj.mldn.javase01.no12;

class Outer2 {

	private String name = "HELLO WORLD!!!";

	public void fun() {

		new Inner( this ).print();    // 打印信息
	}

	public String getName() {

		return this.name;
	}
}

class Inner {

	private Outer2 out;

	public Inner( Outer2 out ) {

		this.out = out;
	}

	public void print() {

		System.out.println( "name = " + this.out.getName() );
	}
}

public class InnerClassDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Outer2().fun();
	}
}
