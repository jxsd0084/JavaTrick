package bj.mldn.javase01.no69.sytemiodemo;

public class SystemErrDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		try {
			Integer.parseInt( "hello" );
		} catch ( Exception e ) {
			System.out.println( e );
			System.err.println( e );
		}
	}

}
