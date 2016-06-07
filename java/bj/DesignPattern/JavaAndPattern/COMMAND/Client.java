package bj.DesignPattern.JavaAndPattern.COMMAND;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		Receiver receiver = new Receiver();
		Command  command  = new ConcreteCommand( receiver );
		Invoker  invoker  = new Invoker( command );

		invoker.action();
	}

	/** @link dependency */
	/*#Receiver lnkReceiver;*/

	/** @link dependency */
    /*#Invoker lnkInvoker;*/

}
