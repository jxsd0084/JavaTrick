package bj.Java1200.col02.ch12_邮件收发.ch12_2_复杂邮件._334;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckAuthenticator extends Authenticator {

	class UserPassDialog extends JDialog {// 用于显示对话框的内部类
		private JPasswordField pf_pwd;
		private JTextField     tf_user;

		public UserPassDialog() {

			super();
			getContentPane().setLayout( null );
			setTitle( "身份验证对话框" );
			setBounds( 100, 100, 253, 165 );

			final JLabel label = new JLabel();
			label.setText( "用户名称：" );
			label.setBounds( 10, 25, 66, 18 );
			getContentPane().add( label );

			tf_user = new JTextField();
			tf_user.setBounds( 82, 23, 146, 22 );
			getContentPane().add( tf_user );

			final JLabel label_1 = new JLabel();
			label_1.setText( "用户密码：" );
			label_1.setBounds( 10, 63, 66, 18 );
			getContentPane().add( label_1 );

			pf_pwd = new JPasswordField();
			pf_pwd.setBounds( 82, 61, 146, 22 );
			getContentPane().add( pf_pwd );

			final JButton btn_ok = new JButton();
			btn_ok.addActionListener( new ActionListener() {
				public void actionPerformed( final ActionEvent e ) {

					setVisible( false );
				}
			} );
			btn_ok.setText( "确  定" );
			btn_ok.setBounds( 20, 89, 92, 28 );
			getContentPane().add( btn_ok );

			final JButton btn_return = new JButton();
			btn_return.addActionListener( new ActionListener() {
				public void actionPerformed( final ActionEvent e ) {

					setVisible( false );
				}
			} );
			btn_return.setText( "返  回" );
			btn_return.setBounds( 132, 89, 92, 28 );
			getContentPane().add( btn_return );
			//
		}

	}

	public PasswordAuthentication getPasswordAuthentication() {

		UserPassDialog dialog = new UserPassDialog();
		dialog.setModal( true );
		dialog.setVisible( true );
		String user = dialog.tf_user.getText().trim();
		String pwd  = new String( dialog.pf_pwd.getPassword() );
		dialog.tf_user.setText( null );
		dialog.pf_pwd.setText( null );
		return new PasswordAuthentication( user, pwd );
	}
}
