package bj.JavaSpecialForces.chapter03.tools;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class JPSTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		List< VirtualMachineDescriptor > machineDescriptors = VirtualMachine.list();
		for ( VirtualMachineDescriptor machineDescriptor : machineDescriptors ) {
			System.out.println( machineDescriptor.id() + "\t" + machineDescriptor.displayName() );
		}
	}
}
