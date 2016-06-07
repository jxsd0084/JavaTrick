package bj.powernode.basic.家庭作业;

/**
 * 倒金字塔
 */
public class work3 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		for ( int k = 0; k <= 5; k++ ) {
			for ( int n = 0; n < k; n++ ) {
				System.out.print( " " );
			}
			for ( int f = 0; f <= 9 - ( 2 * k + 1 ); f++ ) {
				System.out.print( "*" );
			}
			System.out.println();
		}
	}
}
