package bj.Java1200.col01.ch23_数据查询.ch23_1_使用子查询._561_比较运算符引入子查询;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CompareFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField nameTextField1;
	private JTextField nameTextField2;
	private JTable     table;
	private LocalTableModel model = new LocalTableModel();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					CompareFrame frame = new CompareFrame();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public CompareFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 504, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 488, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "查询语文成绩大于" );
		messageLabel.setBounds( 25, 34, 113, 15 );
		panel.add( messageLabel );

		nameTextField1 = new JTextField();
		nameTextField1.setBounds( 141, 31, 66, 21 );
		panel.add( nameTextField1 );
		nameTextField1.setColumns( 10 );

		JLabel label = new JLabel( "小于" );
		label.setBounds( 217, 34, 30, 15 );
		panel.add( label );

		nameTextField2 = new JTextField();
		nameTextField2.setBounds( 245, 31, 66, 21 );
		panel.add( nameTextField2 );
		nameTextField2.setColumns( 10 );

		JLabel label_1 = new JLabel( "的语文成绩" );
		label_1.setBounds( 321, 34, 79, 15 );
		panel.add( label_1 );

		JButton findButton = new JButton( "查询" );
		findButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_findButton_actionPerformed( arg0 );
			}
		} );
		findButton.setBounds( 405, 30, 73, 23 );
		panel.add( findButton );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 40, 78, 418, 163 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
	}

	protected void do_findButton_actionPerformed( ActionEvent arg0 ) {

		String        name1   = nameTextField1.getText();
		String        name2   = nameTextField2.getText();
		CreateCompare compare = new CreateCompare();
		if ( !name1.equals( "" ) && !( name2.equals( "" ) ) ) {
			List list = compare.getCompare( name1, name2 );
			for ( int i = 0; i < list.size(); i++ ) {
				Grade grade = ( Grade ) list.get( i );
				model
						.addRow( new Object[]{ grade.getName(),
								grade.getChinese() } );
			}
		}
	}
}
