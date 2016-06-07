package bj.DesignPattern.JavaAndPattern.observersax.MOUSE;

import java.awt.*;
import java.awt.event.MouseListener;

public class ConcreteSubject extends Frame {

	public ConcreteSubject() {
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] argv ) {
		ConcreteSubject s = new ConcreteSubject();
		MouseListener   m = new ConcreteListener();
		s.setBounds( 100, 100, 100, 100 );
		s.addMouseListener( m );
		s.show();
	}

}
