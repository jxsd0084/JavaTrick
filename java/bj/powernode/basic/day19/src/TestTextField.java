package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

/**
 * 常见组件：java.awt.TextField; --> javax.swing.JTextField;
 * <p>
 * 文本框
 *
 * @author Administrator
 */

public class TestTextField {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		TestTextFieldFrame ttff = new TestTextFieldFrame();
		ttff.setVisible( true );
		ttff.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}

class TestTextFieldFrame extends JFrame {

	public TestTextFieldFrame() {

		setTitle( "测试文本框" );

		setLayout( new FlowLayout() );

		// 准备文本框
		JTextField usernameTextField = new JTextField( 15 );

		usernameTextField.setText( "你好吗" );


		// 添加文本框
		add( usernameTextField );


		// 设置大小和位置
		setBounds( 420, 160, 300, 300 );


	}
}
