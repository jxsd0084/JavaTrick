package bj.DesignPattern.JavaAndPattern.COMMAND.audioplayer2;

/**
 * This class plays the role of Concrete Command
 */

public class PlayCommand implements Command {

	private AudioPlayer myAudio;

	public PlayCommand( AudioPlayer a ) {
		myAudio = a;
	}

	public void execute() {
		myAudio.play();
	}

}
