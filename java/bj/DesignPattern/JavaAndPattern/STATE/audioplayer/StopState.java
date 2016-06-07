package bj.DesignPattern.JavaAndPattern.STATE.audioplayer;

public class StopState extends AudioPlayerState {

	public StopState( AudioPlayer player ) {
		super( player );
	}

	public StopState() {
	}

	public void playButton( AudioPlayer player ) {
		player.setState( this.playState );
		player.startPlay();
	}

}
