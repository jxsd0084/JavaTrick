package bj.DesignPattern.JavaAndPattern.COMMAND;

public class ConcreteCommand implements Command {

	public ConcreteCommand( Receiver receiver ) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action();
	}

	/**
	 * @directed
	 * @clientRole receiver
	 */
	private Receiver receiver;

}
