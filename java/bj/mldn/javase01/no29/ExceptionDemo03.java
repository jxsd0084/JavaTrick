package bj.mldn.javase01.no29;

public class ExceptionDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		int i = 10;
		int j = 1;

		System.out.println( "========== 计算开始 ===========" );

		try {

			int temp = i / j;
			System.out.println( "计算结果：" + temp );

		} catch ( ArithmeticException e ) {
			System.out.println( "出现了数学异常：" + e );

		} finally {
			System.out.println( "** 不管是否有异常，我都执行。" );
		}

		System.out.println( "========== 计算结束 ===========" );
	}

}
