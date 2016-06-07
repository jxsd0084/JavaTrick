package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._583_应用存储过程添加数据;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertUserFrame extends JFrame {

	private JPanel         contentPane;
	private JTextField     userNameTextField;
	private JPasswordField passWordTextField;
	private JTextField     ageTextField;
	private JTextField     jobTextField;
	private JComboBox      sexComboBox;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {

		EventQueue.invokeLater( new Runnable() {
			public void run() {

				try {
					InsertUserFrame frame = new InsertUserFrame();
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
	public InsertUserFrame() {

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 351, 300 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout( null );

		JPanel panel = new JPanel();
		panel.setBounds( 0, 10, 337, 262 );
		contentPane.add( panel );
		panel.setLayout( null );

		JLabel messageLabel = new JLabel( "用户注册" );
		messageLabel.setFont( new Font( "微软雅黑", Font.PLAIN, 15 ) );
		messageLabel.setBounds( 115, 23, 95, 15 );
		panel.add( messageLabel );

		JLabel userNameLabel = new JLabel( "用户名：" );
		userNameLabel.setBounds( 45, 60, 54, 15 );
		panel.add( userNameLabel );

		userNameTextField = new JTextField();
		userNameTextField.setBounds( 109, 57, 171, 21 );
		panel.add( userNameTextField );
		userNameTextField.setColumns( 10 );

		JLabel passwrordLabel = new JLabel( "密  码：" );
		passwrordLabel.setBounds( 45, 91, 54, 15 );
		panel.add( passwrordLabel );

		passWordTextField = new JPasswordField();
		passWordTextField.setBounds( 109, 88, 170, 21 );
		panel.add( passWordTextField );
		passWordTextField.setColumns( 10 );

		JLabel sexLabel = new JLabel( "性  别：" );
		sexLabel.setBounds( 45, 122, 54, 15 );
		panel.add( sexLabel );
		String[] sex = new String[]{ "男", "女" };
		sexComboBox = new JComboBox( sex );
		sexComboBox.setBounds( 109, 119, 87, 21 );
		panel.add( sexComboBox );

		JLabel ageLabel = new JLabel( "年  龄：" );
		ageLabel.setBounds( 45, 155, 54, 15 );
		panel.add( ageLabel );

		ageTextField = new JTextField();
		ageTextField.setBounds( 109, 152, 171, 21 );
		panel.add( ageTextField );
		ageTextField.setColumns( 10 );

		JLabel jobLabel = new JLabel( "工  作：" );
		jobLabel.setBounds( 45, 190, 54, 15 );
		panel.add( jobLabel );

		jobTextField = new JTextField();
		jobTextField.setBounds( 109, 187, 171, 21 );
		panel.add( jobTextField );
		jobTextField.setColumns( 10 );

		JButton insertButton = new JButton( "添加" );
		insertButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_insertButton_actionPerformed( arg0 );
			}
		} );
		insertButton.setBounds( 79, 218, 68, 23 );
		panel.add( insertButton );

		JButton closeButton = new JButton( "关闭" );
		closeButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent arg0 ) {

				do_closeButton_actionPerformed( arg0 );
			}
		} );
		closeButton.setBounds( 175, 218, 68, 23 );
		panel.add( closeButton );
	}

	//添加按钮单击事件
	protected void do_insertButton_actionPerformed( ActionEvent arg0 ) {

		String userName  = userNameTextField.getText();
		String pasString = passWordTextField.getText();
		String age       = ageTextField.getText();
		String sex       = sexComboBox.getSelectedItem().toString();
		String job       = jobTextField.getText();
		User   user      = new User();
		user.setUserName( userName );
		user.setPassword( pasString );
		user.setAge( Integer.parseInt( age ) );
		user.setSex( sex );
		user.setJob( job );
		UserUtil userUtil = new UserUtil();
		boolean  bool     = userUtil.executeUpdate( user );
		if ( bool == true ) {
			JOptionPane.showMessageDialog( getContentPane(),
					"数据添加成功！", "信息提示框", JOptionPane.WARNING_MESSAGE );
		}
	}

	//关闭按钮的单击事件
	protected void do_closeButton_actionPerformed( ActionEvent arg0 ) {

		System.exit( 0 );
	}
}
