package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._544;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class SelectWareFrame extends JFrame {

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
					SelectWareFrame frame = new SelectWareFrame();
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
	public SelectWareFrame() {

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

		JLabel messageLabel = new JLabel( "显示商品表中的所有信息：" );
		messageLabel.setFont( new Font( "华文楷体", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 110, 30, 194, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 46, 80, 337, 142 );
		panel.add( scrollPane );

		table = new JTable( model );
		WareUtil util = new WareUtil();
		List     list = util.selectWare();
		for ( int i = 0; i < list.size(); i++ ) {
			Ware ware = ( Ware ) list.get( i );
			model.addRow( new Object[]{ ware.getSID(), ware.getsName(), ware.getSpec(), ware.getCasing(), ware.getUnit(), ware.getAmout() } );
		}
		scrollPane.setViewportView( table );
	}
}
