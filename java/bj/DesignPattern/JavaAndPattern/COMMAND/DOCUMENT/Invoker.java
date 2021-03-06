package bj.DesignPattern.JavaAndPattern.COMMAND.DOCUMENT;

public class Invoker {

	public Invoker( Command c ) {
		_command = c;
	}

	public void invoke() {
		if ( _command != null ) {
			_command.execute();
		}
	}

	private Command _command;

}
