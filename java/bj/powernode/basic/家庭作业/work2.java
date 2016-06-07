package bj.powernode.basic.家庭作业;

/**
 * 倒直角三角形(空2格)
 */
public class work2 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		for ( int i = 5; i > 0; i-- ) {         // 打印列
			System.out.print( "\t" );
			{
				for ( int j = 0; j < i; j++ ) { // 打印行并控制每行的*数量


					System.out.print( "*" );
				}
				System.out.println();

			}

		}
	}
}
