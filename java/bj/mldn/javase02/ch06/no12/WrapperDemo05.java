package bj.mldn.javase02.ch06.no12;

public class WrapperDemo05 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		int   x = Integer.parseInt( args[ 0 ] );    // 将字符串变为int型
		float f = Float.parseFloat( args[ 1 ] );    // 将字符串变为int型
		System.out.println( "整数乘方：" + x + " * " + x + " = " + ( x * x ) );
		System.out.println( "小数乘方：" + f + " * " + f + " = " + ( f * f ) );
	}
}
