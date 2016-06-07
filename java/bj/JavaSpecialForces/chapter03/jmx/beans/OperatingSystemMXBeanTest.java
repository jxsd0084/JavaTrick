package bj.JavaSpecialForces.chapter03.jmx.beans;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OperatingSystemMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();

		System.out.println( mxBean.getArch() );
		System.out.println( mxBean.getAvailableProcessors() );
		System.out.println( mxBean.getName() );
		System.out.println( mxBean.getSystemLoadAverage() );
		System.out.println( mxBean.getVersion() );

	}

}
