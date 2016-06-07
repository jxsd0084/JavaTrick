package bj.mldn.javase01.no29;

class Math3 {

	public int div( int i, int j ) throws Exception {

		System.out.println( "======== 进行除法操作之前 ============" );

		int temp = 0;

		try {

			temp = i / j;

		} catch ( Exception e ) {
			throw e;    // 抛出异常

		} finally {
			System.out.println( "======== 除法操作完成之后 ============" );

		}
		return temp;
	}
}

public class ExceptionDemo11 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Math3 m = new Math3();

		try {

			int temp = m.div( 10, 0 );
			System.out.println( temp );

		} catch ( Exception e ) {
			System.out.println( e );

		}

	}

}
