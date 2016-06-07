package bj.powernode.basic.家庭作业;

/**
 * 右正直角三角形(空2格)
 */
public class work5 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i <= 7; i++ ) {       /*打印列*/
			System.out.print( "\t" );          /*每列开头*/
			for ( int j = 0; j < i; j++ ) {    /*控制行的数字*/

				System.out.print( "*" );
			}
			System.out.println();
		}
	}
}
