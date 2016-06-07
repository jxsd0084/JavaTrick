package bj.JavaSpecialForces.chapter03.jmx.beans;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
// import sun.management.VMOptionCompositeData;
// import com.sun.management.VMOption;
// import java.lang.management.ManagementFactory;

public class ThreadMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		ThreadMXBean thredMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
		long[]       ids         = thredMXBean.getAllThreadIds();
		for ( long id : ids ) {
			System.out.println( id + "\t" + thredMXBean.getThreadAllocatedBytes( id ) + "\t" + thredMXBean.getThreadInfo( id ) );
		}

		System.out.println( thredMXBean.getCurrentThreadCpuTime() );
		System.out.println( thredMXBean.getCurrentThreadUserTime() );
		System.out.println( thredMXBean.getDaemonThreadCount() );
		System.out.println( thredMXBean.getPeakThreadCount() );
		System.out.println( thredMXBean.getThreadCount() );
		System.out.println( thredMXBean.getTotalStartedThreadCount() );

		System.out.println( "==========================>" );

		displayThreadInfos( thredMXBean, ids );

	}

	private static void displayThreadInfos( ThreadMXBean thredMXBean, long[] ids ) {
		ThreadInfo[] threadInfos = thredMXBean.getThreadInfo( ids );
		for ( ThreadInfo thread : threadInfos ) {
			System.out.println( thread.getThreadName() + "\t"
			                    + thread.getLockOwnerId() + "\t" + thread.getThreadState()
			                    + "\t" + thread.getBlockedCount() + "\t" + thread.getBlockedTime() );

		}
	}

}
