package bj.DesignPattern.JavaAndPattern.COMMAND.television;

public class OnCommand implements Command {

	private Tv myTv;

	public OnCommand( Tv tv ) {
		myTv = tv;
	}

	public void execute() {
		myTv.turnOn();
	}

}
