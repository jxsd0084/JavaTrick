package bj.powernode.basic.家庭作业;

/**
 * 倒金字塔2
 */
public class work4 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		int n = 5;
		for ( int i = n - 1; i >= 0; i-- ) {
			for ( int m = 0; m < n - i; m++ ) {
				System.out.print( " " );
			}
			for ( int m = 0; m <= 2 * i; m++ ) {
				System.out.print( "*" );
			}
			System.out.println();
		}
	}
}
