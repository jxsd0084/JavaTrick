package bj.Java1200.col01.ch24_数据库高级应用.ch24_2_使用触发器._590_在程序中调用UPDATE触发器;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class UpdateTeacherFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableModel model  = new LocalTableModel();
	private TransferUpdate  update = new TransferUpdate();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					UpdateTeacherFrame frame = new UpdateTeacherFrame();
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
	public UpdateTeacherFrame() {

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

		JLabel messageLabel = new JLabel( "教师表中数据" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 172, 24, 102, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 43, 72, 348, 144 );
		panel.add( scrollPane );

		table = new JTable( model );
		List list = update.executeTeacher();
		for ( int i = 0; i < list.size(); i++ ) {
			Teacher teacher = ( Teacher ) list.get( i );
			model.addRow( new Object[]{ teacher.getId(), teacher.gettName(),
					teacher.getCourse() } );
		}
		scrollPane.setViewportView( table );

		JButton updateButton = new JButton( "修改" );
		updateButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_updateButton_actionPerformed( arg0 );
			}
		} );
		updateButton.setBounds( 108, 226, 79, 23 );
		panel.add( updateButton );

		JButton closeButton = new JButton( "关闭" );
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_closeButton_actionPerformed( arg0 );
			}
		} );
		closeButton.setBounds( 233, 226, 79, 23 );
		panel.add( closeButton );
	}

	// 修改按钮的单击处理事件
	protected void do_updateButton_actionPerformed( ActionEvent arg0 ) {

		int    selectedRow = table.getSelectedRow();
		String id          = model.getValueAt( selectedRow, 0 ).toString();
		File   file        = new File( "count.txt" );

		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream( file );
			out.write( id.getBytes() );
			out.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		UpdateFrame updateFrame = new UpdateFrame();
		updateFrame.setVisible( true );
	}

	// 关闭按钮的单击处理事件
	protected void do_closeButton_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
