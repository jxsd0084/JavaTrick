package bj.mldn.javase01.no29;

class Math1 {

	public int div( int i, int j ) throws Exception {

		return i / j;
	}
}

public class ExceptionDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Math1 m = new Math1();

		try {

			int temp = m.div( 10, 0 );
			System.out.println( temp );

		} catch ( Exception e ) {
			e.printStackTrace();    // 打印异常

		}

	}

}
