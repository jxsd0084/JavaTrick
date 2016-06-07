package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._584_调用加密存储过程;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;


public class EncryptFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					EncryptFrame frame = new EncryptFrame();
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
	public EncryptFrame() {

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

		JLabel messageLabel = new JLabel( "调用加密存储过程" );
		messageLabel.setFont( new Font( "华文新魏", Font.PLAIN, 16 ) );
		messageLabel.setBounds( 136, 29, 147, 29 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 28, 76, 367, 164 );
		panel.add( scrollPane );
		LocalTableModel model = new LocalTableModel();
		table = new JTable( model );
		UserUtil util = new UserUtil();
		List     list = util.executeUpdate();
		for ( int i = 0; i < list.size(); i++ ) {
			User user = ( User ) list.get( i );
			model.addRow( new Object[]{ user.getId(), user.getUserName(), user.getPassword(), user.getSex(), user.getAge(), user.getJob() } );
		}
		scrollPane.setViewportView( table );
	}
}
