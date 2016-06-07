package bj.JavaSpecialForces.chapter03.attach;

import java.io.IOException;
import java.util.List;

public class AttachLoadAgentMain {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args )
			throws AttachNotSupportedException,
			IOException, AgentLoadException, AgentInitializationException {

		List< VirtualMachineDescriptor > machineDescriptors = VirtualMachine.list();
		for ( VirtualMachineDescriptor machineDescriptor : machineDescriptors ) {
			String name = machineDescriptor.displayName();

			if ( name != null && name.contains( "RedeineClassMain" ) ) {
				System.out.println( "attach to machine : " + name );
				VirtualMachine machine = VirtualMachine.attach( machineDescriptor );
				machine.loadAgent( "/ux/xxx/redefineclass2.jar" );
				break;
			}

		}

	}

}
