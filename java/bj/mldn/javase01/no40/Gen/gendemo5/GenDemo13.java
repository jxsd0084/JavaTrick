package bj.mldn.javase01.no40.Gen.gendemo5;

public class GenDemo13 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Integer i[] = fun( 1, 2, 3, 4, 5, 6, 7, 8 );
		for ( int x : i ) {

			System.out.print( x + "、" );
		}
	}

	public static < T > T[] fun( T... t ) {

		return t;
	}

}
