package bj.geym.ch2;

public class SimpleArgs {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i < args.length; i++ ) {
			System.out.println( "参数" + ( i + 1 ) + ":" + args[ i ] );
		}
		System.out.println( "-Xmx" + Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M" );
	}
}