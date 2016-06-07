package bj.DesignPattern.JavaAndPattern.STATE.audioplayer;

public class Julie {

	public void main( String[] args ) {
		player = new AudioPlayer();

		player.startButton();
		player.stopButton();
	}

	/**
	 * @link aggregation
	 * @directed
	 */
	private static AudioPlayer player;

}
