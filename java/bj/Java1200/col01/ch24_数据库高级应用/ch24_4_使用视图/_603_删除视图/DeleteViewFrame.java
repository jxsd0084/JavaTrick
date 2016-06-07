package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._603_删除视图;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteViewFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LocalTableModel model = new LocalTableModel();
	private DeleteView      view  = new DeleteView();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					DeleteViewFrame frame = new DeleteViewFrame();
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
	public DeleteViewFrame() {

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

		JLabel messageLabel = new JLabel( "删除数据库中的视图" );
		messageLabel.setFont( new Font( "方正姚体", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 152, 20, 132, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 67, 74, 296, 118 );
		panel.add( scrollPane );

		table = new JTable( model );
		List list = view.executeView();
		for ( int i = 0; i < list.size(); i++ ) {
			model.addRow( new Object[]{ i + 1, list.get( i ) } );
		}
		scrollPane.setViewportView( table );

		JButton deleteButton = new JButton( "删除" );
		deleteButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_deleteButton_actionPerformed( arg0 );
			}
		} );
		deleteButton.setBounds( 98, 214, 81, 23 );
		panel.add( deleteButton );

		JButton closebutton = new JButton( "关闭" );
		closebutton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_closebutton_actionPerformed( arg0 );
			}
		} );
		closebutton.setBounds( 233, 214, 81, 23 );
		panel.add( closebutton );
	}

	protected void do_deleteButton_actionPerformed( ActionEvent arg0 ) {

		int[]  ids      = table.getSelectedRows();           //返回选定行的索引
		String values[] = new String[ ids.length ];
		for ( int i = 0; i < ids.length; i++ ) {    //遍历选定行的数组
			values[ i ] = new String( table.getValueAt( ids[ i ], 1 ).toString() );    //获取用户选择某单元格的内容

		}
		view.executeUpdate( values );
		JOptionPane.showMessageDialog( getContentPane(),
				"视图删除成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );
		repaint();
	}

	protected void do_closebutton_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
