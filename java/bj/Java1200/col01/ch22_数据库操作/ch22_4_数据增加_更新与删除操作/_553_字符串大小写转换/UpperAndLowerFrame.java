package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._553_字符串大小写转换;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class UpperAndLowerFrame extends JFrame {

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
					UpperAndLowerFrame frame = new UpperAndLowerFrame();
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
	public UpperAndLowerFrame() {

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

		JLabel messageLabel = new JLabel( "以大写显示姓以小写显示名" );
		messageLabel.setFont( new Font( "方正姚体", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 127, 22, 188, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 38, 69, 357, 166 );
		panel.add( scrollPane );

		table = new JTable( model );
		UpperAndLower upperAndLower = new UpperAndLower();
		List          list          = upperAndLower.getUpperAndLower();
		for ( int i = 0; i < list.size(); i++ ) {
			Abord abord = ( Abord ) list.get( i );
			model.addRow( new Object[]{ abord.getFristName(), abord.getLastName(), abord.getNationality(), abord.getSpeciality() } );
		}
		scrollPane.setViewportView( table );
	}

}
