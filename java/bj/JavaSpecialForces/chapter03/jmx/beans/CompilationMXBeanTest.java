package bj.JavaSpecialForces.chapter03.jmx.beans;

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;

public class CompilationMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		CompilationMXBean mxBean = ManagementFactory.getCompilationMXBean();

		System.out.println( mxBean.getTotalCompilationTime() );
		System.out.println( mxBean.getName() );
		System.out.println( mxBean.isCompilationTimeMonitoringSupported() );

	}

}
