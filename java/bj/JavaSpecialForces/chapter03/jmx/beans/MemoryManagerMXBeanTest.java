package bj.JavaSpecialForces.chapter03.jmx.beans;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.List;

public class MemoryManagerMXBeanTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws IntrospectionException,
			InstanceNotFoundException, ReflectionException, AttributeNotFoundException, MBeanException {

		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		System.gc();

		List< MemoryManagerMXBean > list = ManagementFactory.getMemoryManagerMXBeans();
		for ( MemoryManagerMXBean memoryManagerMXBean : list ) {
			System.out.println( memoryManagerMXBean.getName() );
			System.out.println( memoryManagerMXBean.getObjectName() );
			MBeanInfo mBeanInfo = mBeanServer.getMBeanInfo( memoryManagerMXBean.getObjectName() );

			MBeanAttributeInfo[] mBeanAttributes = mBeanInfo.getAttributes();
			for ( MBeanAttributeInfo mBeanAttribute : mBeanAttributes ) {
				System.out.println( "=============>" + mBeanAttribute.getName() + "\t" + mBeanAttribute.getType() );
				System.out.println( "=============value = >" + mBeanServer.getAttribute( memoryManagerMXBean.getObjectName(), mBeanAttribute.getName() ) );
			}
			
			/*String []poolNames = memoryManagerMXBean.getMemoryPoolNames();
			for(String poolName : poolNames) {
				System.out.println("\t" + poolName);
			}*/
		}

	}

}
