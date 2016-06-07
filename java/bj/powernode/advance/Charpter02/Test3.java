package bj.powernode.advance.Charpter02;

public class Test3 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "Hello World!" );

		int n    = 5;
		int iSum = sum2( n );
		System.out.println( "1--" + n + " 的累加结果是:" + iSum );
	}

	// 不使用递归方法计算从1 至 n 的累加的和

	public static int sum1( int n ) {

		int sum = 0;

		if ( n == 1 ) {
			return 1;
		} else {
			for ( int i = 1; i <= n; i++ ) {
				sum += i;
			}
			return sum;
		}
	}


	// 使用递归方法计算从1 至 n 的累加的和
	public static int sum2( int n ) {

		if ( n == 1 ) {
			return 1;

		} else {
			return n + sum2( n - 1 );

		}
	}

}
