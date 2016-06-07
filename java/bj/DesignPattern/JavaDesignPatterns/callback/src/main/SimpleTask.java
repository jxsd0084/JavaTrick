package bj.DesignPattern.JavaDesignPatterns.callback.src.main;

/**
 * Implementation of task that need to be executed
 */
public class SimpleTask extends Task {

	@Override
	public void execute() {

		System.out.println( "Perform some important activity and after call the callback method." );
	}

}
