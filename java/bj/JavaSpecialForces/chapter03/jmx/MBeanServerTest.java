package bj.JavaSpecialForces.chapter03.jmx;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class MBeanServerTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws MalformedObjectNameException,
			IntrospectionException, InstanceNotFoundException,
			AttributeNotFoundException, ReflectionException, MBeanException,
			IOException {
		// System.gc();
		// System.out.println(JMXUtils.getYongGC());
		// System.out.println(JMXUtils.getFullGC());

		JMXUtils.traceAll( ManagementFactory.getPlatformMBeanServer() );

	}

}
