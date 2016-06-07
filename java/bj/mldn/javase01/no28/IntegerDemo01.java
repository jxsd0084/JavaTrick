package bj.mldn.javase01.no28;

public class IntegerDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		int     i  = 10;

		Integer i2 = new Integer( i );    // 装箱操作

		int     j  = i2.intValue();       // 拆箱操作

		System.out.println( j * j );

	}

}
