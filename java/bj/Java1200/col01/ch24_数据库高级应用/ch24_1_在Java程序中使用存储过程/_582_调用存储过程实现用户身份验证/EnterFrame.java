package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._582_调用存储过程实现用户身份验证;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField userTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					EnterFrame frame = new EnterFrame();
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
	public EnterFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 382, 259 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );
		setTitle( "登录窗体" );
		JPanel panel = new JPanel();
		panel.setBounds( 427, 0, -423, 262 );
		contentPane.add( panel );

		JLabel userLabel = new JLabel( "用户名：" );
		userLabel.setBounds( 71, 71, 54, 15 );
		contentPane.add( userLabel );

		userTextField = new JTextField();
		userTextField.setBounds( 135, 68, 137, 21 );
		contentPane.add( userTextField );
		userTextField.setColumns( 10 );

		JLabel passWordLabel = new JLabel( " 密  码：" );
		passWordLabel.setBounds( 76, 117, 60, 15 );
		contentPane.add( passWordLabel );

		passwordTextField = new JTextField();
		passwordTextField.setBounds( 135, 114, 137, 21 );
		contentPane.add( passwordTextField );
		passwordTextField.setColumns( 10 );

		JButton enterButton = new JButton( "登录" );
		enterButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_enterButton_actionPerformed( arg0 );
			}
		} );
		enterButton.setBounds( 89, 162, 67, 23 );
		contentPane.add( enterButton );

		JButton closeButton = new JButton( "关闭" );
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_closeButton_actionPerformed( arg0 );
			}
		} );
		closeButton.setBounds( 191, 162, 67, 23 );
		contentPane.add( closeButton );
	}

	// 登录按钮的单击事件
	protected void do_enterButton_actionPerformed( ActionEvent arg0 ) {

		String          userName        = userTextField.getText();
		String          passWord        = passwordTextField.getText();
		TransferProcure transferProcure = new TransferProcure();
		if ( !userName.equals( "" ) && ( !passWord.equals( "" ) ) ) {
			String message = transferProcure.executeQuery( userName, passWord );
			JOptionPane.showMessageDialog( getContentPane(), message, "警告提示框",
					JOptionPane.WARNING_MESSAGE );
		}

	}

	// 关闭按钮的单击事件
	protected void do_closeButton_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
