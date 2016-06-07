package bj.powernode.basic.day26.GUI_Examples.list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JList4 {

	public JList4() {

		JFrame    f           = new JFrame( "JList" );
		Container contentPane = f.getContentPane();

		ListModel mode = new DataModel_02();
		JList     list = new JList( mode );
		list.setVisibleRowCount( 5 );
		list.setBorder( BorderFactory.createTitledBorder( "您最喜欢到哪个国家玩呢？" ) );

		contentPane.add( new JScrollPane( list ) );
		f.pack();
		f.show();
		f.addWindowListener( new WindowAdapter() {

			public void windowClosing( WindowEvent e ) {

				System.exit( 0 );
			}
		} );
	}

	public static void main( String args[] ) {

		new JList4();
	}
}

/*
 * 使DataModel继承DefaultListModel实体类，因此就不需要再实作getSize()与getElementAt()两个方法，
 * 直接将所要的项目用addElementAt()方法加入即可。系统会自动将所加入的项目放入一个Vector对象中,
 * 并在输出JList时自动调用getSize()与getElementAt()方法。你可以在DefaultListModel类中找到getSize()与
 * getElementAt()两个方法，你可以发现这两个方法已经被实作，不再是抽象方法了。
 */
class DataModel_02 extends DefaultListModel {

	String[] s = { "美国", " 日本", "大陆", "英国", "法国", "意大利", "澳洲", "韩国" };

	DataModel_02() {

		for ( int i = 0; i < s.length; i++ ) {
			addElement( ( i + 1 ) + "." + s[ i ] );
		}
	}
}
