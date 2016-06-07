package bj.JavaSpecialForces.chapter03.jmx.beans;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class MemoryPoolMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		List< MemoryPoolMXBean > list = ManagementFactory.getMemoryPoolMXBeans();
		for ( MemoryPoolMXBean memoryPoolMXBean : list ) {
			System.out.println( memoryPoolMXBean.getName()
			                    + memoryPoolMXBean.getCollectionUsage()
			                    + "\n\nPeakUsage:\t\t" + memoryPoolMXBean.getPeakUsage()
			                    + "\n\nUsage:\t\t" + memoryPoolMXBean.getUsage() );
			/*
			 * + memoryPoolMXBean.getUsageThreshold() + "\t" +
			 * memoryPoolMXBean.getUsageThresholdCount() +
			 * "\t\n\nCollectionUsage:\t\t"
			 * 
			 * + memoryPoolMXBean.getType() + "\t"
			 */
			// memoryPoolMXBean.getCollectionUsageThreshold() + "\t"
			// memoryPoolMXBean.getCollectionUsageThresholdCount() + "\t" );
			// String []memoryManagerNames =
			// memoryPoolMXBean.getMemoryManagerNames();
			/*
			 * for(String memoryManagerName : memoryManagerNames) {
			 * System.out.println("\t\t\t\t" + memoryManagerName); }
			 */

		}
	}
}
