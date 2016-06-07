package bj.powernode.basic.day26.GUI_Examples.radiobutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JRadioButton2 implements ItemListener {

	JFrame       f  = null;
	JRadioButton r4 = null;
	JRadioButton r5 = null;

	JRadioButton2() {

		f = new JFrame( "JRadioButton2" );
		Container contentPane = f.getContentPane();
		contentPane.setLayout( new GridLayout( 2, 1 ) );


		JPanel p1 = new JPanel();
		p1.setLayout( new GridLayout( 1, 3 ) );
		p1.setBorder( BorderFactory.createTitledBorder( "你最喜欢哪一家快餐店呢?" ) );
		JRadioButton r1 = new JRadioButton( "麦当劳" );
		JRadioButton r2 = new JRadioButton( "肯德基" );
		JRadioButton r3 = new JRadioButton( "21世纪" );
		p1.add( r1 );
		p1.add( r2 );
		p1.add( r3 );
/*
  将3个RadioButton对象放进ButtonGroup中，表示此3个RadioButton同一时间只有一个RadioButton的状态可以为"on";
*/
		ButtonGroup bgroup1 = new ButtonGroup();
		bgroup1.add( r1 );
		bgroup1.add( r2 );
		bgroup1.add( r3 );


		JPanel p2 = new JPanel();
		p2.setLayout( new GridLayout( 2, 1 ) );
		p2.setBorder( BorderFactory.createTitledBorder( "你最喜欢哪种程序语言，喜欢的请打勾:" ) );
		r4 = new JRadioButton( "java", new ImageIcon( ".\\icons\\x.jpg" ) );
		r5 = new JRadioButton( "c++", new ImageIcon( ".\\icons\\x.jpg" ) );
		r4.addItemListener( this );
		r5.addItemListener( this );
		p2.add( r4 );
		p2.add( r5 );
		ButtonGroup bgroup2 = new ButtonGroup();
		bgroup2.add( r4 );
		bgroup2.add( r5 );
		contentPane.add( p1 );
		contentPane.add( p2 );
		f.pack();
		f.show();
		f.addWindowListener( new WindowAdapter() {

			public void windowClosing( WindowEvent e ) {

				System.exit( 0 );
			}
		} );
	}

	public void itemStateChanged( ItemEvent e ) {

		if ( e.getStateChange() == e.SELECTED ) {
			if ( e.getSource() == r4 ) {
				r4.setIcon( new ImageIcon( ".\\icons\\r.jpg" ) );
			}
			if ( e.getSource() == r5 ) {
				r5.setIcon( new ImageIcon( ".\\icons\\r.jpg" ) );
			}
		} else {
			if ( e.getSource() == r4 ) {
				r4.setIcon( new ImageIcon( ".\\icons\\x.jpg" ) );
			}
			if ( e.getSource() == r5 ) {
				r5.setIcon( new ImageIcon( ".\\icons\\x.jpg" ) );
			}
		}
	}

	public static void main( String[] args ) {

		new JRadioButton2();
	}
}

