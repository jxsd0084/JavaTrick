package bj.powernode.basic.day20.focus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * FocusListener: 组件获取焦点和失去焦点的事件监听
 *
 * @author Administrator
 */
public class UserRegisterFrame extends JFrame {

	private JLabel usernameLabel, errorInfoLabel;
	private JTextField usernameTextField;

	public UserRegisterFrame() {

		setTitle( "用户注册" );

		setLayout( new FlowLayout( FlowLayout.LEFT ) );     // 流式布局方式

		usernameLabel = new JLabel( "username" );
		usernameTextField = new JTextField( 15 );

		usernameTextField.addFocusListener( new FocusListener() {

			@Override
			public void focusGained( FocusEvent e ) {       // 组件获取焦点
				errorInfoLabel.setText( "" );
			}

			@Override
			public void focusLost( FocusEvent e ) {         // 组件失去焦点
				String username = usernameTextField.getText();

				if ( username.length() == 0 ) {
					// errorInfoLabel.setText("用户名不能为空");
					JOptionPane.showMessageDialog( UserRegisterFrame.this, "用户名不能为空", "错误", JOptionPane.ERROR_MESSAGE );
				} else if ( username.length() < 6 ) {
					// errorInfoLabel.setText("用户名长度不能少于6位");
					JOptionPane.showMessageDialog( UserRegisterFrame.this, "用户名长度不能少于6位", "错误", JOptionPane.ERROR_MESSAGE );
				}

			}
		} );

		errorInfoLabel = new JLabel();


		add( usernameLabel );
		add( usernameTextField );
		add( errorInfoLabel );

		setBounds( 420, 160, 600, 100 );
	}


	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		UserRegisterFrame urf = new UserRegisterFrame();
		urf.setVisible( true );
		urf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
