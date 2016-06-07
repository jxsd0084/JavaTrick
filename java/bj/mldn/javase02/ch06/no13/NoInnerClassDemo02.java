package bj.mldn.javase02.ch06.no13;

interface A1 {

	public void printInfo();
}

class X1 {

	public void fun1() {

		this.fun2( new A1() {

			           public void printInfo() {

				           System.out.println( "Hello World!!!" );
			           }
		           }
		);
	}

	public void fun2( A1 a ) {

		a.printInfo();
	}
}

public class NoInnerClassDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		new X1().fun1();        // 实例化X类的对象，并调用fun1()方法
	}
}
