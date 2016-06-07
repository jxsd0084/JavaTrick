package bj.DesignPattern.JavaAndPattern.COMMAND.swingundo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* App panel class
 */
class TextAreaUndoDemoPanel extends JPanel {

	// Constructor
	public TextAreaUndoDemoPanel() {
		setLayout( new BorderLayout() );

		// create an undoable text area
		// must be final to be accessed by
		// anonymous inner classes (listeners)
		final UndoableTextArea text
				= new UndoableTextArea( "Your text here." );

		// create a toolbar for buttons
		JToolBar toolbar = new JToolBar();

		// create undo and redo buttons
		// add listeners for buttons
		JButton buttonUndo, buttonRedo;
		buttonUndo = new JButton( "Undo" );
		buttonUndo.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				text.undo();
			}
		} );
		buttonRedo = new JButton( "Redo" );
		buttonRedo.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				text.redo();
			}
		} );

		// add buttons to toolbar
		toolbar.add( buttonUndo );
		toolbar.add( buttonRedo );

		// add toolbar and text area to panel
		add( toolbar, "North" );
		add( text, "Center" );
	}
} 

