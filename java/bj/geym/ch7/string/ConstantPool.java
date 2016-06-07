package bj.geym.ch7.string;

public class ConstantPool {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		if ( args.length == 0 ) {
			return;
		}
		System.out.println( System.identityHashCode( ( args[ 0 ] + Integer.toString( 0 ) ) ) );
		System.out.println( System.identityHashCode( ( args[ 0 ] + Integer.toString( 0 ) ).intern() ) );
		System.gc();
		System.out.println( System.identityHashCode( ( args[ 0 ] + Integer.toString( 0 ) ).intern() ) );
	}
}
