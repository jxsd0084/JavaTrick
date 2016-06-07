package bj.powernode.basic.day26.GUI_Examples.table;
/* (swing1.1beta3) */
//package jp.gr.java_conf.tame.swing.examples;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @version 1.0 11/09/98
 */

class RowHeaderRenderer extends JLabel implements ListCellRenderer {

	RowHeaderRenderer( JTable table ) {

		JTableHeader header = table.getTableHeader();
		setOpaque( true );
		setBorder( UIManager.getBorder( "TableHeader.cellBorder" ) );
		setHorizontalAlignment( CENTER );
		setForeground( header.getForeground() );
		setBackground( header.getBackground() );
		setFont( header.getFont() );
	}

	public Component getListCellRendererComponent( JList list,
	                                               Object value, int index, boolean isSelected, boolean cellHasFocus ) {

		setText( ( value == null ) ? "" : value.toString() );
		return this;
	}
}

public class RowHeaderExample extends JFrame {

	public RowHeaderExample() {

		super( "Row Header Example" );
		setSize( 300, 150 );

		ListModel lm = new AbstractListModel() {

			String headers[] = { "a", "b", "c", "d", "e", "f", "g", "h", "mmm" };

			public int getSize() {

				return headers.length;
			}

			public Object getElementAt( int index ) {

				return headers[ index ];
			}
		};

		DefaultTableModel dm    = new DefaultTableModel( lm.getSize(), 10 );
		JTable            table = new JTable( dm );
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

		JList rowHeader = new JList( lm );
		rowHeader.setFixedCellWidth( 50 );

//    rowHeader.setFixedCellHeight(table.getRowHeight()
//                               );
//                             + table.getIntercellSpacing().height);
		rowHeader.setCellRenderer( new RowHeaderRenderer( table ) );

		JScrollPane scroll = new JScrollPane( table );
		scroll.setRowHeaderView( rowHeader );
		getContentPane().add( scroll, BorderLayout.CENTER );
	}

	public static void main( String[] args ) {

		RowHeaderExample frame = new RowHeaderExample();
		frame.addWindowListener( new WindowAdapter() {

			public void windowClosing( WindowEvent e ) {

				System.exit( 0 );
			}
		} );
		frame.setVisible( true );
	}
}
