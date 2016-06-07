package bj.Java1200.col01.ch23_数据查询.ch23_3_连接查询._570_左外连接查询员工信息;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class SelectUseLeftFrame extends JFrame {

	private JPanel contentPane;

	private LocalTableModel model = new LocalTableModel();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					SelectUseLeftFrame frame = new SelectUseLeftFrame();
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
	public SelectUseLeftFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 622, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "左外连接查询数据" );
		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 606, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "左外连接查询同学信息" );
		messageLabel.setFont( new Font( "华文中宋", Font.PLAIN, 15 ) );
		messageLabel.setBounds( 215, 26, 165, 27 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 43, 78, 512, 161 );
		panel.add( scrollPane );

		table_1 = new JTable( model );
		SelectUseLeft useLeft = new SelectUseLeft();
		List          list    = useLeft.getLeft();
		for ( int i = 0; i < list.size(); i++ ) {
			MrEmp mrEmp = ( MrEmp ) list.get( i );
			model.addRow( new Object[]{ mrEmp.getId(), mrEmp.getdName(),
					mrEmp.getPerson(), mrEmp.getName(), mrEmp.getSex(), mrEmp.getSchoolAge() } );
		}
		scrollPane.setViewportView( table_1 );
	}
}
