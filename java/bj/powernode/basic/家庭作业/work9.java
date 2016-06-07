package bj.powernode.basic.家庭作业;

/**
 * 正金字塔
 */
public class work9 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i <= 4; i++ ) {

			for ( int t = 0; t < 4 - i; t++ ) {

				System.out.print( " " );
			}

			for ( int j = 0; j < 2 * i + 1; j++ ) {

				System.out.print( "*" );
			}

			System.out.println();
		}


	}


}
