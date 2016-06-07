package bj.powernode.basic.家庭作业;

/**
 * 左正直角三角形
 */
public class work8 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i <= 5; i++ ) {
			for ( int t = 0; t < 5 - i; t++ ) {
				System.out.print( " " );

			}
			for ( int j = 0; j < i; j++ ) {
				System.out.print( "*" );
			}

			System.out.println();
		}
	}
}
