package bj.powernode.basic.day23.GUI_Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class JList1 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {
		JFrame    f           = new JFrame( "JList" );
		Container contentPane = f.getContentPane();
		contentPane.setLayout( new GridLayout( 1, 2 ) );
		String[] s = { "美国", "日本", "大陆", "英国", "法国" };
		Vector   v = new Vector();
		v.addElement( "Nokia 8850" );
		v.addElement( "Nokia 8250" );
		v.addElement( "Motorola V8088" );
		v.addElement( "Motorola V3688x" );
		v.addElement( "Panasonic GD92" );
		v.addElement( "其他" );

		JList list1 = new JList( s );
		list1.setBorder( BorderFactory.createTitledBorder( "您最喜欢到哪个国家玩呢？" ) );

		JList list2 = new JList( v );
		list2.setBorder( BorderFactory.createTitledBorder( "您最喜欢哪一种手机？" ) );

		contentPane.add( new JScrollPane( list1 ) );
		contentPane.add( new JScrollPane( list2 ) );
		f.pack();
		f.show();
		f.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				System.exit( 0 );
			}
		} );
	}
}
