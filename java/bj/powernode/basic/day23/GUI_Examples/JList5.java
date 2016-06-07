package bj.powernode.basic.day23.GUI_Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JList5 {

	public JList5() {

		JFrame    f           = new JFrame( "JList" );
		Container contentPane = f.getContentPane();
		contentPane.setLayout( new GridLayout( 1, 2 ) );
		ListModel mode  = new DataModel5( 1 );
		JList     list1 = new JList( mode );
		list1.setVisibleRowCount( 5 );
		list1.setBorder( BorderFactory.createTitledBorder( "您玩过哪些软件？" ) );

		mode = new DataModel5( 2 );
		JList list2 = new JList( mode );
		list2.setBorder( BorderFactory.createTitledBorder( "您玩过哪些数据库软件？" ) );

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

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		new JList5();
	}
}

class DataModel5 extends AbstractListModel {

	String[] s = { "MS SQL", "MySQL", "IBM DB2", "ORACLE", "Windows 2000", "Linux", "UNix", "OS2" };
	int flag;

	DataModel5( int flag ) {

		this.flag = flag;
	}

	public Object getElementAt( int index ) {

		String tmp = null;

		if ( flag == 1 ) {
			tmp = ( index + 1 ) + "." + s[ index++ ];
		}
		if ( flag == 2 ) {
			if ( index < 4 ) {
				tmp = ( index + 1 ) + "." + s[ index++ ];
			}
		}

		return tmp;
	}

	public int getSize() {

		return s.length;
	}
}
