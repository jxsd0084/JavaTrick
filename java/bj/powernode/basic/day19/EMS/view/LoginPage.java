package bj.powernode.basic.day19.EMS.view;

import bj.powernode.basic.day21.employees_mgt_sys.basic.GBC;
import bj.powernode.basic.day21.employees_mgt_sys.basic.GuiUtil;
import bj.powernode.basic.day21.employees_mgt_sys.basic.Insets;
import bj.powernode.basic.day21.employees_mgt_sys.basic.LanguageHandlerUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 用户管理系统中的登录界面
 *
 * @version 1.0
 */
public class LoginPage extends JFrame {

	private static final long serialVersionUID = 5048885220310996469L;

	private JPanel panel;
	private JLabel loginLabel, usernameLabel, passwordLabel;
	private JTextField     usernameTextField;
	private JPasswordField pwdField;
	private JButton        loginBut, exitBut, entryBut;

	private LoginPage() {

		this.setTitle( LanguageHandlerUtil.getContentByKey( "loginPage.title" ) ); // 设置窗体的标题栏
		this.setIconImage( GuiUtil.getImage( "src/image/1.jpg" ) );                // 处置窗体图标

		// 适合不同分辨率(设置窗体的大小)
		int width  = GuiUtil.getScreenWidth();
		int height = GuiUtil.getScreenHeight();
		this.setBounds( (int) ( width / 2.5 ), height / 3, (int) ( width / 4 ), (int) ( height / 3.5 ) );

		panel = new JPanel();                   // 创建面板
		panel.setLayout( new GridBagLayout() ); // 设置面板的布局方式


		// 向面板添加“用户登录”Label
		loginLabel = new JLabel( LanguageHandlerUtil.getContentByKey( "loginPage.loginLabel" ) );
		panel.add( loginLabel, new GBC( 0, 0, 3, 1 ).setWeight( 100, 100 ).setInsetsOfX( 10, Insets.TOP ) );


		// 向面板添加“用户名”Label
		usernameLabel = new JLabel( LanguageHandlerUtil.getContentByKey( "loginPage.usernameLabel" ) );
		panel.add( usernameLabel, new GBC( 0, 1, 1, 1 ).setWeight( 100, 100 ).setAnchor( GBC.EAST ) );

		// 向面板添加输入用户名的文本框
		usernameTextField = new JTextField( 14 );
		usernameTextField.setToolTipText( LanguageHandlerUtil.getContentByKey( "loginPage.usernameTextField.tooltip" ) );
		panel.add( usernameTextField, new GBC( 1, 1, 2, 1 ).setWeight( 100, 100 ).setAnchor( GBC.WEST ).setInsetsOfX( 10, Insets.LEFT ) );

		// 向面板中添加“密码”Label
		passwordLabel = new JLabel( LanguageHandlerUtil.getContentByKey( "loginPage.passwordLabel" ) );
		panel.add( passwordLabel, new GBC( 0, 2, 1, 1 ).setWeight( 100, 100 ).setAnchor( GBC.EAST ) );

		// 向面板添加密码框
		pwdField = new JPasswordField( 14 );
		pwdField.setToolTipText( LanguageHandlerUtil.getContentByKey( "loginPage.pwdField.tooltip" ) );
		panel.add( pwdField, new GBC( 1, 2, 2, 1 ).setWeight( 100, 100 ).setAnchor( GBC.WEST ).setInsetsOfX( 10, Insets.LEFT ) );


		// 向面板添加登录按钮
		loginBut = new JButton( LanguageHandlerUtil.getContentByKey( "loginPage.loginBut" ) );
		loginBut.setToolTipText( LanguageHandlerUtil.getContentByKey( "loginPage.loginBut.tooltip" ) );
		panel.add( loginBut, new GBC( 0, 3, 3, 1 ).setWeight( 100, 100 ).setAnchor( GBC.WEST ).setInsetsOfX( 50, Insets.LEFT ) );


		// 向面板添加退出按钮
		exitBut = new JButton( LanguageHandlerUtil.getContentByKey( "loginPage.exitBut" ) );
		exitBut.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				System.exit( 1 ); // 退出系统
			}
		} );
		exitBut.setToolTipText( LanguageHandlerUtil.getContentByKey( "loginPage.exitBut.tooltip" ) );
		panel.add( exitBut, new GBC( 0, 3, 3, 1 ).setWeight( 100, 100 ).setAnchor( GBC.EAST ).setInsetsOfX( 50, Insets.RIGHT ) );

		// 向面板添加注册按钮
		entryBut = new JButton( LanguageHandlerUtil.getContentByKey( "loginPage.entryBut" ) );
		entryBut.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {

				LoginPage.this.setVisible( false ); // 隐藏登录界面
				new EntryPage();                    // 显示录入页面
			}
		} );
		entryBut.setToolTipText( LanguageHandlerUtil.getContentByKey( "loginPage.entryBut.tooltip" ) );
		panel.add( entryBut, new GBC( 0, 3, 3, 1 ).setWeight( 100, 100 ).setAnchor( GBC.CENTER ) );


		// 添加面板
		this.add( panel );

		this.setResizable( false );                     // 不可改变大小
		this.setVisible( true );                        // 设置可见
		this.setDefaultCloseOperation( EXIT_ON_CLOSE ); // 设置关闭时推出系统
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		new LoginPage();
	}

}
