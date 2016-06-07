package bj.DesignPattern.JavaAndPattern.COMMAND.ITSUKYU;

public class RedoCommand extends Command {

	UndoableTextArea text;

	public RedoCommand( UndoableTextArea text ) {
		super( "Redo" );
		this.text = text;
	}

	public void execute() {
		text.redo();
	}

}
