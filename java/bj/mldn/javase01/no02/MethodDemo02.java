package bj.mldn.javase01.no02;

public class MethodDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( add( 10, 20 ) );

		System.out.println( add( 30, 30 ) );

	}

	public static int add( int x, int y ) {

		int temp = x + y;

		return temp;    // 将计算结果返回
	}

}
