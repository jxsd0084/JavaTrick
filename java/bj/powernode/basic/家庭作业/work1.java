package bj.powernode.basic.家庭作业;

/**
 * 100元买鸡问题
 */
public class work1 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		int m = 0;//公鸡 male
		int f = 0;//母鸡 female
		int c = 0;//小鸡 child

		for ( m = 100 / 5; m >= 0; m-- ) {

			for ( f = 0; 3 * f <= 100 - 5 * m; f++ ) {
				c = ( 100 - 5 * m - 3 * f ) * 3;

				if ( m + f + c == 100 ) {
					System.out.println( "公鸡-" + m + " 母鸡-" + f + " 小鸡-" + c );
				}
			}
		}
	}
}
