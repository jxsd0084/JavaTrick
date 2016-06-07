package bj.powernode.basic.家庭作业;

/**
 * 正金字塔2
 */
public class work10 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int n = 5; // 行数
		for ( int i = 0; i < n; i++ ) {
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
