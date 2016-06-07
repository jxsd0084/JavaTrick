package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_1_文件的读取与写入._440;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GetPropertiesFrame extends JFrame {

	private JPanel     contentPane;
	private JTextField driveTextField;
	private JTextField connectionTextField;
	private JTextField userNameTextField;
	private JTextField passWordTextField;
	GetProperties properties = new GetProperties();

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					GetPropertiesFrame frame = new GetPropertiesFrame();
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
	public GetPropertiesFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 493, 248 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		setTitle( "从属性文件中读取数据" );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 0, 477, 210 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel driveLabel = new JLabel( "数据库驱动：" );
		driveLabel.setBounds( 53, 39, 81, 15 );
		panel.add( driveLabel );

		driveTextField = new JTextField();
		driveTextField.setBounds( 133, 36, 291, 21 );
		driveTextField.setText( properties.getProperties( "className" ) );
		panel.add( driveTextField );
		driveTextField.setColumns( 10 );

		JLabel connectionLabel = new JLabel( "连接字符串：" );
		connectionLabel.setBounds( 53, 80, 81, 15 );
		panel.add( connectionLabel );

		connectionTextField = new JTextField();
		connectionTextField.setColumns( 10 );
		connectionTextField.setText( properties.getProperties( "url" ) );
		connectionTextField.setBounds( 133, 77, 291, 21 );
		panel.add( connectionTextField );

		JLabel userNameLabel = new JLabel( "用  户  名 ：" );
		userNameLabel.setBounds( 53, 122, 81, 15 );
		panel.add( userNameLabel );

		JLabel passwordLabel = new JLabel( "  密     码：" );
		passwordLabel.setBounds( 42, 160, 81, 15 );
		panel.add( passwordLabel );

		userNameTextField = new JTextField();
		userNameTextField.setColumns( 10 );
		userNameTextField.setBounds( 133, 119, 291, 21 );
		panel.add( userNameTextField );
		userNameTextField.setText( properties.getProperties( "userName" ) );
		passWordTextField = new JTextField();
		passWordTextField.setColumns( 10 );
		passWordTextField.setBounds( 133, 157, 291, 21 );
		passWordTextField.setText( properties.getProperties( "passWord" ) );
		panel.add( passWordTextField );
	}
}
