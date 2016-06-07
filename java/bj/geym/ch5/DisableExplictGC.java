package bj.geym.ch5;

/**
 * -XX:+PrintGCDetails -XX:-DisableExplicitGC
 *
 * @author geym
 */
public class DisableExplictGC {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		while ( true ) {
			System.gc();
			Thread.yield();
		}
	}
}
