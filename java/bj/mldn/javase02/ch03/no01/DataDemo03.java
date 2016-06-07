package bj.mldn.javase02.ch03.no01;

public class DataDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		int max = Integer.MAX_VALUE;        // 求出最大值
		System.out.println( "整型的最大值：" + max );
		System.out.println( "整型的最大值 + 1：" + ( max + 1 ) );
		System.out.println( "整型的最大值 + 2：" + ( max + 2 ) );
		System.out.println( "整型的最大值 + 2：" + ( (long) max + 2 ) );



	}
}
