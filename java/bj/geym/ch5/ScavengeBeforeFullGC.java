package bj.geym.ch5;


/**
 * -XX:+PrintGCDetails  -XX:-ScavengeBeforeFullGC -XX:+UseParallelOldGC
 * <p>
 * <p>
 * -XX:+PrintGCDetails -XX:+UseSerialGC
 *
 * @author geym
 */
public class ScavengeBeforeFullGC {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		System.gc();
	}
}
