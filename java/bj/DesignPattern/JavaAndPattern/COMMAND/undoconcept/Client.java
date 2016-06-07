package bj.DesignPattern.JavaAndPattern.COMMAND.undoconcept;

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
	/*#com.javapatterns.command.undoconcept.Receiver lnkReceiver;*/

	/** @link dependency */
    /*#com.javapatterns.command.undoconcept.Invoker lnkInvoker;*/

}
