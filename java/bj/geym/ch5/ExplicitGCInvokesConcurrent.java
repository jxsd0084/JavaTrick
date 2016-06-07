package bj.geym.ch5;

/**
 * -XX:+PrintGCDetails -XX:+ExplicitGCInvokesConcurrent -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+ExplicitGCInvokesConcurrent -XX:+UseG1GC
 * <p>
 * ExplicitGCInvokesConcurrent 在System.gc()时会使用并发方式 回收
 *
 * @author geym
 */
public class ExplicitGCInvokesConcurrent {

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
