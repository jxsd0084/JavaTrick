package bj.mldn.javase02.ch08.no02;

class SubHelloDemo extends HelloDemo {

	public void print() {

		System.out.println( "访问受保护属性：" + super.name );
	}
}

public class ProtectedDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		SubHelloDemo sub = new SubHelloDemo();
		sub.print();
	}
}
