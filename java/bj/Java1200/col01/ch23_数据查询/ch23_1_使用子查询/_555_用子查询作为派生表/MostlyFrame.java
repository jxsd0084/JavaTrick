package bj.Java1200.col01.ch23_数据查询.ch23_1_使用子查询._555_用子查询作为派生表;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MostlyFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MostlyModel model  = new MostlyModel();
	private DeriveTable dtable = new DeriveTable();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					MostlyFrame frame = new MostlyFrame();
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
	public MostlyFrame() {

		setBounds( 100, 100, 450, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 434, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "查询员工表中主要信息：" );
		messageLabel.setBounds( 134, 27, 148, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 39, 68, 349, 172 );
		panel.add( scrollPane );

		table = new JTable( model );
		List list = dtable.getSubTable();
		for ( int i = 0; i < list.size(); i++ ) {
			Emp emp = ( Emp ) list.get( i );
			model.addRow( new Object[]{ emp.getId(), emp.getName(),
					emp.getHeadship(), emp.getLaborage() } );
		}
		scrollPane.setViewportView( table );
	}
}
