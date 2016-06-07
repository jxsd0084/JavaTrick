package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;


/**
 * 常用组件之：密码框  java.awt.PasswordField; javax.swing.JPasswordField;
 *
 * @author Administrator
 */
public class TestPasswordField {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		TestPwdFieldFrame tpff = new TestPwdFieldFrame();
		tpff.setVisible( true );
		tpff.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}

class TestPwdFieldFrame extends JFrame {

	public TestPwdFieldFrame() {
		setTitle( "密码框" );

		// 设置布局管理器
		setLayout( new FlowLayout() );

		// 准备密码框
		JPasswordField pwdField = new JPasswordField( 15 );


		// 添加
		add( pwdField );


		// 设置大小和位置
		setBounds( 420, 160, 300, 300 );
	}
}
