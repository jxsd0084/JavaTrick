package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._602_修改视图;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					UpdateViewFrame frame = new UpdateViewFrame();
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
	public UpdateViewFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 499, 396 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		MyJPanel panel = new MyJPanel();
		panel.setBounds( 0, 0, 483, 361 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "修改视图" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 14 ) );
		messageLabel.setBounds( 203, 31, 63, 15 );
		panel.add( messageLabel );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 76, 95, 325, 136 );
		panel.add( scrollPane );


		scrollPane.setViewportView( textArea );

		JButton updateButton = new JButton( "修改" );
		updateButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_updateButton_actionPerformed( arg0 );
			}
		} );
		updateButton.setBounds( 139, 267, 69, 23 );
		panel.add( updateButton );

		JButton closeButton = new JButton( "关闭" );
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_closeButton_actionPerformed( arg0 );
			}
		} );
		closeButton.setBounds( 265, 267, 69, 23 );
		panel.add( closeButton );

	}

	//修改按钮的单击事件
	protected void do_updateButton_actionPerformed( ActionEvent arg0 ) {

		String     content = textArea.getText();
		UpdateView view    = new UpdateView();
		view.executeUpdate( content );
		JOptionPane.showMessageDialog( getContentPane(),
				"视图修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );

	}

	//关闭按钮的单击事件
	protected void do_closeButton_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
