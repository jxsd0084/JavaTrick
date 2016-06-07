package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._597_创建视图;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					CreateViewFrame frame = new CreateViewFrame();
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
	public CreateViewFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 496, 396 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "创建视图" );
		MyJPanel panel = new MyJPanel();
		panel.setBounds( 0, 0, 483, 361 );
		contentPane.add( panel );
		panel.setLayout( null );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds( 69, 92, 328, 158 );
		panel.add( scrollPane );


		scrollPane.setViewportView( textArea );

		JButton createButton = new JButton( "创建" );
		createButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_createButton_actionPerformed( arg0 );
			}
		} );
		createButton.setBounds( 123, 284, 72, 23 );
		panel.add( createButton );

		JButton cancelButton = new JButton( "取消" );
		cancelButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_cancelButton_actionPerformed( arg0 );
			}
		} );
		cancelButton.setBounds( 258, 284, 72, 23 );
		panel.add( cancelButton );
	}

	//创建按钮的单击事件
	protected void do_createButton_actionPerformed( ActionEvent arg0 ) {

		String     sql  = textArea.getText();
		CreateView view = new CreateView();
		view.executeUpdate( sql );
		JOptionPane.showMessageDialog( getContentPane(),
				"视图创建成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );

	}

	//取消按钮的单击事件
	protected void do_cancelButton_actionPerformed( ActionEvent arg0 ) {

		textArea.setText( "" );
	}
}
