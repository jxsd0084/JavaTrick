package bj.geym.ch8.lockeli;


/**
 * -server -XX:+DoEscapeAnalysis -XX:-EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
 * <p>
 * -server -XX:+DoEscapeAnalysis -XX:+EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
 */
public class LockEliminate {

	private static final int CIRCLE = 2000000;

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) throws InterruptedException {

		long start = System.currentTimeMillis();
		for ( int i = 0; i < CIRCLE; i++ ) {
			craeteStringBuffer( "JVM", "Diagnosis" );
		}
		long bufferCost = System.currentTimeMillis() - start;
		System.out.println( "craeteStringBuffer: " + bufferCost + " ms" );
	}

	public static String craeteStringBuffer( String s1, String s2 ) {

		StringBuffer sb = new StringBuffer();
		sb.append( s1 );
		sb.append( s2 );
		return sb.toString();
	}
}
