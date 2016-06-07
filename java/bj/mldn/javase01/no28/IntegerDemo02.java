package bj.mldn.javase01.no28;

public class IntegerDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		int     i  = 10;

		Integer i2 = i;    // 自动装箱操作

		int     j  = i2;   // 自动拆箱操作

		System.out.println( j * j );

	}

}
