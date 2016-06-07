package bj.mldn.javase02.ch03.no01;

public class DataDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		int max = Integer.MAX_VALUE;        // 求出最大值
		System.out.println( "Integer.Max -> " + max );
		System.out.println( "Integer.Max + 1 -> " + ( max + 1 ) );
		System.out.println( "Integer.Max + 2 -> " + ( max + 2 ) );



		String hexStr = Integer.toHexString( 1 );
		System.out.println( "toHexString -> " + hexStr );



		hexStr = Integer.toHexString( 10 );
		System.out.println( "toHexString -> " + hexStr );



		hexStr = Integer.toHexString( 15 );
		System.out.println( "toHexString -> " + hexStr );



		int res = Integer.compare( 1, 2 );
		System.out.println( "compare -> " + res );



		res = Integer.compare( 1, 1 );
		System.out.println( "compare -> " + res );



		res = Integer.compare( 2, 1 );
		System.out.println( "compare -> " + res );



		res = Integer.sum( 1, 2 );
		System.out.println( "sum -> " + res );



		res = Integer.parseInt( "1" );
		System.out.println( "parseInt -> " + res );



		res = Integer.parseInt( "10", 2 );
		System.out.println( "parseInt -> " + res );



		res = Integer.parseInt( "10", 10 );
		System.out.println( "parseInt -> " + res );



		res = Integer.parseInt( "10", 16 );
		System.out.println( "parseInt -> " + res );



		res = Integer.signum( -100 );
		System.out.println( "signum -> " + res );



		res = Integer.signum( 0 );
		System.out.println( "signum -> " + res );



		res = Integer.signum( 100 );
		System.out.println( "signum -> " + res );

	}
}
