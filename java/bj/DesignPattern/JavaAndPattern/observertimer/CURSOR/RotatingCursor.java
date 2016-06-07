package bj.DesignPattern.JavaAndPattern.observertimer.CURSOR;

import javax.swing.*;
import java.applet.Applet;

public class RotatingCursor extends Applet {

	private Action timerAction;
	private Timer  timer;

	public void init() {
		timerAction = new TimerAction( this );
		timer = new Timer( 300, timerAction );
		timer.start();
	}

}
