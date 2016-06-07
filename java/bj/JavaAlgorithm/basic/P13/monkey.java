package bj.JavaAlgorithm.basic.P13;


public class monkey {

	static int total( int day ) {

		if ( day == 10 ) {
			return 1;
		} else {
			return ( total( day + 1 ) + 1 ) * 2;
		}
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( total( 1 ) );
	}
}

