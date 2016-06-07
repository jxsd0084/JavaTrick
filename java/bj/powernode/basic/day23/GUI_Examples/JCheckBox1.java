package bj.powernode.basic.day23.GUI_Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JCheckBox1 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		JFrame    f           = new JFrame( "JCheckBox1" );
		Container contentPane = f.getContentPane();
		contentPane.setLayout( new GridLayout( 2, 1 ) );
		JPanel p1 = new JPanel();
		p1.setLayout( new GridLayout( 1, 3 ) );
		p1.setBorder( BorderFactory.createTitledBorder( "你最喜欢哪一家快餐店呢？" ) );
		JCheckBox c1 = new JCheckBox( "麦当劳" );
		JCheckBox c2 = new JCheckBox( "肯德基" );
		JCheckBox c3 = new JCheckBox( "21世纪" );
		p1.add( c1 );
		p1.add( c2 );
		p1.add( c3 );


		JPanel p2 = new JPanel();
		p2.setLayout( new GridLayout( 2, 1 ) );
		p2.setBorder( BorderFactory.createTitledBorder( "以下为JCheckBox的图形示范:" ) );
		JCheckBox c4 = new JCheckBox( "图形1", new ImageIcon( "src/image/1.jpg" ) );
		JCheckBox c5 = new JCheckBox( "图形2", new ImageIcon( "src/image/1.jpg" ) );
		p2.add( c4 );
		p2.add( c5 );
		contentPane.add( p1 );
		contentPane.add( p2 );
		f.pack();
		f.setVisible( true );
		f.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		} );
	}
}
