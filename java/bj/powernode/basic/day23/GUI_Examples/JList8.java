package bj.powernode.basic.day23.GUI_Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JList8 extends MouseAdapter {

	JList            list1 = null;
	JList            list2 = null;
	DefaultListModel mode1 = null;
	DefaultListModel mode2 = null;
	String[]         s     = { "美国", "日本", "大陆", "英国", "法国", "意大利", "澳洲", "韩国" };

	public JList8() {
		JFrame    f           = new JFrame( "JList" );
		Container contentPane = f.getContentPane();
		contentPane.setLayout( new GridLayout( 1, 2 ) );

		mode1 = new DataModel( 1 );
		list1 = new JList( mode1 );
		list1.setBorder( BorderFactory.createTitledBorder( "国家名称!" ) );
		list1.addMouseListener( this );//一遇到鼠标事件立即执行.

		mode2 = new DataModel( 2 );
		list2 = new JList( mode2 );
		list2.setBorder( BorderFactory.createTitledBorder( "你最喜欢到哪个国家玩呢!" ) );
		list2.addMouseListener( this );//一遇到鼠标事件立即执行.

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
	public static void main( String[] args ) {
		new JList8();
	}

	//处理鼠标键击事件.
	public void mouseClicked( MouseEvent e ) {
		int index;
	/*对list1而言，当鼠标在某个项目连续按两下时，我们利用JList所提供的locationToIndex()方法，找到所键击的项目，并
     *由tmp取得此项目的项目值，然后将此项目值增加到mode2中[mode2.addElement(tmp)],用setModel重新设置list2的
     *ListModel,使list2可显示出所增加的项目，将刚刚在list1双击的项目删除.
     */
		if ( e.getSource() == list1 ) {
			if ( e.getClickCount() == 2 ) {
				index = list1.locationToIndex( e.getPoint() );
				String tmp = (String) mode1.getElementAt( index );
				mode2.addElement( tmp );
				list2.setModel( mode2 );
				mode1.removeElementAt( index );
				list1.setModel( mode1 );
			}
		}
		if ( e.getSource() == list2 ) {
			if ( e.getClickCount() == 2 ) {
				index = list2.locationToIndex( e.getPoint() );
				String tmp = (String) mode2.getElementAt( index );
				mode1.addElement( tmp );
				list1.setModel( mode1 );
				mode2.removeElementAt( index );
				list2.setModel( mode2 );
			}
		}
	}

	class DataModel extends DefaultListModel {

		DataModel( int flag ) {
			if ( flag == 1 ) {
				for ( int i = 0; i < s.length; i++ ) {
					addElement( s[ i ] );
				}
			}
		}
	}
}
