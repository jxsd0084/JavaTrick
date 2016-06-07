package bj.powernode.basic.day20.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowWarningDialogFrame extends JFrame {

	private JButton showWarningDialogButton;

	public ShowWarningDialogFrame() {

		setLayout( new FlowLayout( FlowLayout.CENTER ) );

		setTitle( "这是一个显示警告框的窗口" );

		showWarningDialogButton = new JButton( "显示警告框" );

		showWarningDialogButton.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				// JOptionPane.showMessageDialog(ShowWarningDialogFrame.this, "数组下标越界","警告",JOptionPane.WARNING_MESSAGE);
				// JOptionPane.showMessageDialog(ShowWarningDialogFrame.this, "用户名无效","错误",JOptionPane.ERROR_MESSAGE);
				// JOptionPane.showMessageDialog(ShowWarningDialogFrame.this, "你满18岁了","询问",JOptionPane.QUESTION_MESSAGE);

				int result = JOptionPane.showConfirmDialog( ShowWarningDialogFrame.this, "您真的要删除这个用户信息", "确认是否删除", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
				System.out.println( result );
			}
		} );

		setBounds( 420, 160, 500, 400 );

		add( showWarningDialogButton );
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		ShowWarningDialogFrame a = new ShowWarningDialogFrame();
		a.setVisible( true );
		a.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
