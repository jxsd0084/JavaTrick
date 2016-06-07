package bj.mldn.javase01.no32;

class DemoB extends DemoA {

	public void print() {

		System.out.println( super.name );
	}
}

public class TestDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		DemoB d = new DemoB();

		d.print();

		d.name = "";

	}

}