package bj.DesignPattern.JavaAndPattern.COMMAND.lightandfan;

public class LightOffCommand implements Command {

	private Light myLight;

	public LightOffCommand( Light L ) {
		myLight = L;
	}

	public void execute() {
		myLight.turnOff();
	}

}
