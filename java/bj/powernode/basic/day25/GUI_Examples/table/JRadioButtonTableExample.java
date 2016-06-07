package bj.powernode.basic.day25.GUI_Examples.table;
/* (swing1.1beta3) */
//package jp.gr.java_conf.tame.swing.examples;

/**
 * @version 1.0 12/03/98
 */
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RadioButtonRenderer implements TableCellRenderer {

	public Component getTableCellRendererComponent( JTable table, Object value,
	                                                boolean isSelected, boolean hasFocus, int row, int column ) {

		if ( value == null ) {
			return null;
		}
		return (Component) value;
	}
}

class RadioButtonEditor extends DefaultCellEditor implements ItemListener {

	private JRadioButton button;

	public RadioButtonEditor( JCheckBox checkBox ) {

		super( checkBox );
	}

	public Component getTableCellEditorComponent( JTable table, Object value,
	                                              boolean isSelected, int row, int column ) {

		if ( value == null ) {
			return null;
		}
		button = (JRadioButton) value;
		button.addItemListener( this );
		return (Component) value;
	}

	public Object getCellEditorValue() {

		button.removeItemListener( this );
		return button;
	}

	public void itemStateChanged( ItemEvent e ) {

		super.fireEditingStopped();
	}
}

public class JRadioButtonTableExample extends JFrame {

	public JRadioButtonTableExample() {

		super( "JRadioButtonTable Example" );
		UIDefaults ui = UIManager.getLookAndFeel().getDefaults();
		UIManager.put( "RadioButton.focus", ui.getColor( "control" ) );

		DefaultTableModel dm = new DefaultTableModel();
		dm.setDataVector( new Object[][]{
				{ "Group 1", new JRadioButton( "A" ) },
				{ "Group 1", new JRadioButton( "B" ) },
				{ "Group 1", new JRadioButton( "C" ) },
				{ "Group 2", new JRadioButton( "a" ) },
				{ "Group 2", new JRadioButton( "b" ) }
		}, new Object[]{
				"String", "JRadioButton"
		} );

		JTable table = new JTable( dm ) {

			public void tableChanged( TableModelEvent e ) {

				super.tableChanged( e );
				repaint();
			}
		};
		ButtonGroup group1 = new ButtonGroup();
		group1.add( (JRadioButton) dm.getValueAt( 0, 1 ) );
		group1.add( (JRadioButton) dm.getValueAt( 1, 1 ) );
		group1.add( (JRadioButton) dm.getValueAt( 2, 1 ) );
		ButtonGroup group2 = new ButtonGroup();
		group2.add( (JRadioButton) dm.getValueAt( 3, 1 ) );
		group2.add( (JRadioButton) dm.getValueAt( 4, 1 ) );
		table.getColumn( "JRadioButton" ).setCellRenderer(
				new RadioButtonRenderer() );
		table.getColumn( "JRadioButton" ).setCellEditor(
				new RadioButtonEditor( new JCheckBox() ) );
		JScrollPane scroll = new JScrollPane( table );
		getContentPane().add( scroll );
		setSize( 200, 140 );
		setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		JRadioButtonTableExample frame = new JRadioButtonTableExample();
		frame.addWindowListener( new WindowAdapter() {

			public void windowClosing( WindowEvent e ) {

				System.exit( 0 );
			}
		} );
	}
}
