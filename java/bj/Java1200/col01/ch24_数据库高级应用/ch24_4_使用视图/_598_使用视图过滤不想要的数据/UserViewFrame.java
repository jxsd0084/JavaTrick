package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._598_使用视图过滤不想要的数据;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class UserViewFrame extends JFrame {

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
					UserViewFrame frame = new UserViewFrame();
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
	public UserViewFrame() {

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

		JLabel messageLabel = new JLabel( "调用视图查询数据" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 148, 28, 152, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 44, 70, 325, 141 );
		panel.add( scrollPane );

		table = new JTable( model );
		UserView userView = new UserView();
		List     list     = userView.selectView();
		for ( int i = 0; i < list.size(); i++ ) {
			Laborage laborage = ( Laborage ) list.get( i );
			model.addRow( new Object[]{ laborage.getId(), laborage.getName(), laborage.getDept(), laborage.getLaborage() } );
		}
		scrollPane.setViewportView( table );
	}
}
