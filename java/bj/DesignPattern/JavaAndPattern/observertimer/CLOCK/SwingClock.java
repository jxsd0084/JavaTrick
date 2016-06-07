package bj.DesignPattern.JavaAndPattern.observertimer.CLOCK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class SwingClock extends java.applet.Applet {

	private Timer clock = new Timer( 1000,
			new ActionListener() {
				public void actionPerformed( ActionEvent e ) {
					synchronized ( SwingClock.this ) {
						repaint();
					}
				}
			}
	);

	public void init() {
		setBackground( Color.green );
		setFont( new Font( "TimesRoman", Font.BOLD, 36 ) );

	}

	public void paint( Graphics g ) {
		Calendar   cal           = Calendar.getInstance();
		Date       date          = cal.getTime();
		DateFormat dateFormatter = DateFormat.getTimeInstance();
		g.drawString( dateFormatter.format( date ), 5, 100 );
	}

	public SwingClock() throws InterruptedException {
		clock.start();
	}

}
