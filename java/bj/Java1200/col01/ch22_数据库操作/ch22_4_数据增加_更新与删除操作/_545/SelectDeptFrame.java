package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._545;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class SelectDeptFrame extends JFrame {

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
					SelectDeptFrame frame = new SelectDeptFrame();
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
	public SelectDeptFrame() {

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

		JLabel messageLabel = new JLabel( "显示部门信息表中的所有信息：" );
		messageLabel.setFont( new Font( "华文楷体", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 110, 30, 223, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 46, 80, 337, 142 );
		panel.add( scrollPane );

		table = new JTable( model );
		DeptUtil util = new DeptUtil();
		List     list = util.selectDept();
		for ( int i = 0; i < list.size(); i++ ) {
			Dept dept = ( Dept ) list.get( i );
			model.addRow( new Object[]{ dept.getDid(), dept.getdName(), dept.getPriName() } );
		}
		scrollPane.setViewportView( table );
	}
}
