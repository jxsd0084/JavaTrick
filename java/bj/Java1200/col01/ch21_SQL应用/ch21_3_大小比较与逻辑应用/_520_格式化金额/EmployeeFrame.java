package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._520_格式化金额;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class EmployeeFrame extends JFrame {

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
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JLabel messageLabel = new JLabel( "对金额进行格式化" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 136, 28, 140, 15 );
		contentPane.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 59, 65, 319, 148 );
		contentPane.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
		EmployeeUtil pay  = new EmployeeUtil();
		List         list = pay.getEmp();
		for ( int i = 0; i < list.size(); i++ ) {
			EmployeePay employeePay = ( EmployeePay ) list.get( i );
			model.addRow( new Object[]{ employeePay.getId(), employeePay.geteName(), employeePay.getOldEarning() } );
		}
	}

}
