package bj.JavaSpecialForces.chapter03.jmx.beans;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

		// memoryMXBean.gc();
		System.out.println( memoryMXBean.getHeapMemoryUsage() );
		System.out.println( memoryMXBean.getObjectPendingFinalizationCount() );
		System.out.println( memoryMXBean.getNonHeapMemoryUsage() );

	}

}
