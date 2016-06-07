package bj.powernode.basic.家庭作业;//用java输出一个实心菱形

/**
 * 实心菱形
 */
public class work7 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		int n = 4;

		// 前4行.上半部分
		for ( int i = 1; i <= n; i++ ) {                // 控制行数

			for ( int k = n - 1; k >= i; k-- ) {        // 打印空格

				System.out.print( " " );
			}
			for ( int j = 1; j <= 2 * i - 1; j++ ) {    // 打印*

				System.out.print( "*" );
			}
			System.out.println();
		}


		// 后3行,下半部分
		for ( int i = n - 1; i >= 1; i-- ) {
			for ( int k = i; k <= n - 1; k++ ) {
				System.out.print( " " );
			}
			for ( int j = 1; j <= 2 * i - 1; j++ ) {
				System.out.print( "*" );
			}
			System.out.println();
		}
	}
}
