package bj.mldn.javase01.no28;

public class FloatDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "12.3";                   // 字符串由数字组成

		float  i   = Float.parseFloat( str );    // 将字符串变为int型

		System.out.println( i * i );

	}

}
