package bj.mldn.javase01.no02;

public class MethodDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		int sum = 0;

		sum = fun( 100 );

		System.out.println( "计算结果：" + sum );

	}

	public static int fun( int temp ) {

		if ( temp == 1 ) {
			return 1;

		} else {
			return temp + fun( temp - 1 );
		}
	}

}
