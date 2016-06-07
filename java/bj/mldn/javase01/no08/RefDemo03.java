package bj.mldn.javase01.no08;

class Demo2 {

	String x = "mldn";
}

public class RefDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Demo2 d = new Demo2();

		d.x = "hello";

		fun( d );

		System.out.println( d.x );

	}

	public static void fun( Demo2 temp ) {

		temp.x = "world";
	}

}
