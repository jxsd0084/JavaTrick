package bj.powernode.basic.家庭作业;

/**
 * 正反直角三角形
 */
public class work6 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i <= 5; i++ ) {

			System.out.print( "\t" );

			for ( int j = 0; j < i; j++ ) {

				System.out.print( "*" );

			}
			System.out.println();

		}

		for ( int k = 5; k >= 0; k-- ) {

			System.out.print( "\t" );

			for ( int l = 1; l < k; l++ ) {

				System.out.print( "*" );

			}
			System.out.println();
		}
	}
}
