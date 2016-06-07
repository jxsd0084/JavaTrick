package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

public class Test01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		MyFrame myFrame = new MyFrame();
		MyPanel myPanel = new MyPanel();
		myFrame.add( myPanel );
	}

}


class MyFrame extends JFrame {

	public MyFrame() {
		setLayout( null );
		setTitle( "My Frame" );
		setSize( 200, 200 );
		setLocation( 200, 200 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}


class MyPanel extends JPanel {

	public MyPanel() {
		setSize( 100, 100 );
		setLocation( 50, 50 );
		setBackground( Color.MAGENTA );
	}
}
