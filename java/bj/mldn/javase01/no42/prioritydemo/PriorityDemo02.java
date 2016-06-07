package bj.mldn.javase01.no42.prioritydemo;

public class PriorityDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( Thread.currentThread().getPriority() );

		System.out.println( "** Thread.MAX_PRIORITY = " + Thread.MAX_PRIORITY );
		System.out.println( "** Thread.NORM_PRIORITY = " + Thread.NORM_PRIORITY );
		System.out.println( "** Thread.MIN_PRIORITY = " + Thread.MIN_PRIORITY );

	}

}
