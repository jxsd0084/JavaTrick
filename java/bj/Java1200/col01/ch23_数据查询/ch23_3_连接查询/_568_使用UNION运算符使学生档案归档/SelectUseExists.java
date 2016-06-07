package bj.Java1200.col01.ch23_数据查询.ch23_3_连接查询._568_使用UNION运算符使学生档案归档;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class SelectUseExists extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableModel model = new LocalTableModel();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					SelectUseExists frame = new SelectUseExists();
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
	public SelectUseExists() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "使用UNION运算符使用学生档案归档" );
		messageLabel.setFont( new Font( "华文中宋", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 101, 10, 269, 31 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 40, 51, 345, 185 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
		StudentUnion studentUnion = new StudentUnion();
		List         list         = studentUnion.getMessageEmp();
		for ( int i = 0; i < list.size(); i++ ) {
			Student student = ( Student ) list.get( i );
			model.addRow( new Object[]{ student.getId(), student.getName(),
					student.getSex(), student.getSpciality(), student.getAddress() } );
		}

	}
}
