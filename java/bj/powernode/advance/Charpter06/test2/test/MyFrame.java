package bj.powernode.advance.Charpter06.test2.test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

	public MyFrame( String title ) {

		super( title );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		MyFrame mf = new MyFrame( "我的窗口程序" );
		mf.addWindowListener( new MyWindowListener() );
		mf.setSize( 500, 300 );
		mf.setLocation( 300, 300 );
		mf.setVisible( true );
	}
	// 
}

class MyWindowListener extends WindowAdapter {

	@Override
	public void windowClosing( WindowEvent e ) {

		System.exit( 0 );
	}
}

/*
 * class MyWindowListener implements WindowListener {
 * 
 * @Override public void windowActivated(WindowEvent e) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void windowClosed(WindowEvent e) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * 
 * 
 * @Override public void windowDeactivated(WindowEvent e) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void windowDeiconified(WindowEvent e) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void windowIconified(WindowEvent e) { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * @Override public void windowOpened(WindowEvent e) {
 * 
 * }
 * 
 * }
 */
