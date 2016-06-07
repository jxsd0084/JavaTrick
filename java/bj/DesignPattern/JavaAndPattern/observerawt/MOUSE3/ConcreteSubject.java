package bj.DesignPattern.JavaAndPattern.observerawt.MOUSE3;

import java.awt.*;
import java.awt.event.MouseListener;

public class ConcreteSubject extends Frame {

	/**
	 * @link aggregation
	 */
	private static MouseListener m;

	public ConcreteSubject() {
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] argv ) {
		ConcreteSubject s = new ConcreteSubject();
		m = new ConcreteListener();
		s.setBounds( 100, 100, 100, 100 );
		s.addMouseListener( m );
		s.show();
	}

}
