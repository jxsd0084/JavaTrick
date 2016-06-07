package bj.powernode.basic.day26.EMS.view;

import bj.powernode.basic.day26.EMS.common.GBC;
import bj.powernode.basic.day26.EMS.common.Orientation;
import bj.powernode.basic.day26.EMS.common.ScreenSizeKit;
import bj.powernode.basic.day26.EMS.entity.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 员工信息管理系统中的登录界面，管理员可以通过该入口进入员工信息操作页面
 *
 * @author Administrator
 */
public class AdminLoginPage extends JFrame {

	/**
	 * 抽象登录页面的属性.
	 * 包含7个属性：
	 * 3个JLabel
	 * 1个文本框
	 * 1个密码框
	 * 2个按钮
	 */
	private JLabel adminLoginLabel, usernameLabel, pwdLabel;
	private JTextField     usernameTextField;
	private JPasswordField pwdField;
	private JButton        loginButton, exitButton;
	private JPanel loginPanel;


	public AdminLoginPage() {
		//初始化登录页面中的所有组件
		adminLoginLabel = new JLabel( "管理员登录" );
		usernameLabel = new JLabel( "用户名" );
		pwdLabel = new JLabel( "密    码" );
		usernameTextField = new JTextField( 12 );
		pwdField = new JPasswordField( 12 );
		loginButton = new JButton( "登录" );
		exitButton = new JButton( "退出" );
		loginPanel = new JPanel();

		//设置标题
		setTitle( "管理员登录" );

		//设置登录页面的大小和位置
		setBounds( (int) ( ScreenSizeKit.getWidth() / 2.7 ),
		           ScreenSizeKit.getHeight() / 3,
		           ScreenSizeKit.getWidth() / 5,
		           ScreenSizeKit.getHeight() / 4 );


		//将面板添加到登录页面
		add( loginPanel );

		//设置面板的布局方式(网格组布局)
		loginPanel.setLayout( new GridBagLayout() );

		//将组件添加到面板上
		loginPanel.add( adminLoginLabel, new GBC( 0, 0, 3, 1, 100, 100 ) );
		loginPanel.add( usernameLabel, new GBC( 0, 1, 1, 1, 100, 100 ).setInsets( ScreenSizeKit.getWidth() / 50, Orientation.LEFT ) );
		loginPanel.add( usernameTextField, new GBC( 1, 1, 2, 1, 100, 100 ).setAnchor( GBC.WEST ) );
		loginPanel.add( pwdLabel, new GBC( 0, 2, 1, 1, 100, 100 ).setInsets( ScreenSizeKit.getWidth() / 50, Orientation.LEFT ) );
		loginPanel.add( pwdField, new GBC( 1, 2, 2, 1, 100, 100 ).setAnchor( GBC.WEST ) );
		loginPanel.add( loginButton, new GBC( 0, 3, 3, 1, 100, 100 ).setAnchor( GBC.WEST ).setInsets( ScreenSizeKit.getWidth() / 25, Orientation.LEFT ) );
		loginPanel.add( exitButton, new GBC( 0, 3, 3, 1, 100, 100 ).setAnchor( GBC.EAST ).setInsets( ScreenSizeKit.getWidth() / 25, Orientation.RIGHT ) );


		//给对应的按钮添加监听
		exitButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				System.exit( 0 );
			}
		} );

		//点击登录按钮
		loginButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				goLogin();
			}
		} );

		//给按钮添加回车键监听
		loginButton.addKeyListener( new KeyAdapter() {

			@Override
			public void keyTyped( KeyEvent e ) {
				//回车键对应'\n'
				if ( e.getKeyChar() == '\n' ) {
					goLogin();
				}
			}
		} );

		//设置不可变
		setResizable( false );


	}

	//去登录
	public void goLogin() {

		String username = usernameTextField.getText();
		String password = new String( pwdField.getPassword() );

		Administrator admin = new Administrator( username, password );

		boolean isSuccess = admin.login();

		if ( isSuccess ) { //成功

			//隐藏登录界面
			setVisible( false );

			//初始化操作界面
			OperationPage op = new OperationPage();
			op.setVisible( true );
			op.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		} else {//失败
			JOptionPane.showMessageDialog( AdminLoginPage.this, "用户名不存在或者密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE );
		}
	}

	/**
	 * 整个项目的入口
	 */
	public static void main( String[] args ) {

		AdminLoginPage loginPage = new AdminLoginPage();
		loginPage.setVisible( true );
		loginPage.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
