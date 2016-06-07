package bj.mldn.javase01.no29;

public class ExceptionDemo10 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		try {

			throw new Exception( "抛着玩的。" );    // 人为抛出

		} catch ( Exception e ) {

			System.out.println( e );
		}

	}

}
