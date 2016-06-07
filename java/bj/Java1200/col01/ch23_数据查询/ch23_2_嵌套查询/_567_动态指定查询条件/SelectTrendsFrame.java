package bj.Java1200.col01.ch23_数据查询.ch23_2_嵌套查询._567_动态指定查询条件;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectTrendsFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField valueTextField;
	private JTable     table;
	private LocalTableModel model = new LocalTableModel();
	private JComboBox subjectComboBox;
	private JComboBox connectionComboBox;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					SelectTrendsFrame frame = new SelectTrendsFrame();
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
	public SelectTrendsFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 501, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 485, 262 );
		contentPane.add( panel );
		panel.setLayout( null );
		setTitle( "动态指定查询条件" );
		JLabel subjectLabel = new JLabel( "学科：" );
		subjectLabel.setBounds( 33, 32, 54, 15 );
		panel.add( subjectLabel );
		String[] subject = { "数学", "语文", "英语" };
		subjectComboBox = new JComboBox( subject );
		subjectComboBox.setBounds( 73, 29, 69, 21 );
		panel.add( subjectComboBox );

		JLabel connectionLabel = new JLabel( "关系：" );
		connectionLabel.setBounds( 152, 32, 41, 15 );
		panel.add( connectionLabel );
		String[] connection = { "=", "<", ">" };
		connectionComboBox = new JComboBox( connection );
		connectionComboBox.setBounds( 192, 29, 54, 21 );
		panel.add( connectionComboBox );

		JLabel valueLabel = new JLabel( "值：" );
		valueLabel.setBounds( 256, 32, 34, 15 );
		panel.add( valueLabel );

		valueTextField = new JTextField();
		valueTextField.setBounds( 290, 29, 66, 21 );
		panel.add( valueTextField );
		valueTextField.setColumns( 10 );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 33, 90, 418, 144 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );

		JButton findButton = new JButton( "查询" );
		findButton.setBounds( 382, 28, 69, 23 );
		panel.add( findButton );
		findButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_findButton_actionPerformed( arg0 );
			}
		} );
	}

	protected void do_findButton_actionPerformed( ActionEvent arg0 ) {

		String subject      = subjectComboBox.getSelectedItem().toString();
		String connection   = connectionComboBox.getSelectedItem().toString();
		String value        = valueTextField.getText();
		String subjectValue = "";
		if ( subject.equals( "数学" ) ) {
			subjectValue = "math";
		}
		if ( subject.equals( "英语" ) ) {
			subjectValue = "english";
		}
		if ( subject.equals( "语文" ) ) {
			subjectValue = "chinese";
		}
		TrendsSelect selectT = new TrendsSelect();
		model.setRowCount( 0 );
		List list = selectT.getGrade( subjectValue, connection, Integer.parseInt( value ) );
		for ( int i = 0; i < list.size(); i++ ) {
			Grade grade = ( Grade ) list.get( i );
			model.addRow( new Object[]{ grade.getId(), grade.getName(),
					grade.getSex(), grade.getEnglish(), grade.getChinese(),
					grade.getMath() } );
		}
	}
}
