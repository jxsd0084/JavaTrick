package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._120_局部内部类的简单应用;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmClock {

	private int     delay;
	private boolean flag;

	public AlarmClock( int delay, boolean flag ) {

		this.delay = delay;
		this.flag = flag;
	}

	public void start() {

		class Printer implements ActionListener {

			@Override
			public void actionPerformed( ActionEvent e ) {

				SimpleDateFormat format = new SimpleDateFormat( "k:m:s" );
				String           result = format.format( new Date() );
				System.out.println( "当前的时间是：" + result );
				if ( flag ) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		new Timer( delay, new Printer() ).start();
	}
}
