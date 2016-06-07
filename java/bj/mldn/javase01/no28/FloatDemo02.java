package bj.mldn.javase01.no28;

public class FloatDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		float i  = 10.3f;

		Float i2 = i;    // 装箱操作

		float j  = i2;   // 拆箱操作

		System.out.println( j * j );

	}

}
