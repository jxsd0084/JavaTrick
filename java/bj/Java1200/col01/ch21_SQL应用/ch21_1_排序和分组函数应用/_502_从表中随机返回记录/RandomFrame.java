package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._502_从表中随机返回记录;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RandomFrame extends JFrame {

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
					RandomFrame frame = new RandomFrame();
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
	public RandomFrame() {

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

		JLabel messageLabel = new JLabel( "随机获取3名留学生信息：" );
		messageLabel.setBounds( 72, 29, 150, 15 );
		panel.add( messageLabel );

		JButton findButton = new JButton( "查询" );
		findButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_findButton_actionPerformed( arg0 );
			}
		} );
		findButton.setBounds( 242, 25, 77, 23 );
		panel.add( findButton );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 51, 83, 334, 138 );
		panel.add( scrollPane );

		table = new JTable( model );
		scrollPane.setViewportView( table );
	}

	//查询按钮的单击处理事件
	protected void do_findButton_actionPerformed( ActionEvent arg0 ) {

		AbroadUtil util = new AbroadUtil();
		model.setRowCount( 0 );  //将表格清空
		List list = util.getAbroad();
		for ( int i = 0; i < list.size(); i++ ) {
			Abroad abroad = ( Abroad ) list.get( i );
			model.addRow( new Object[]{ abroad.getId(), abroad.getFristName(), abroad.getLastName(), abroad.getNationality(), abroad.getSpeciality() } );
		}
	}

}
