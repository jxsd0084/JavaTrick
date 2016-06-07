package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * GUI中的基本的事件监听机制.
 * <p>
 * 监听器: ActionListener
 * <p>
 * 按钮被用户点击的时候,ActionListener可以检测到这个事件发生了.
 * <p>
 * 在GUI中有很多类型的监听器,每一个类型的监听器监听的事件不相同.
 *
 * @author Administrator
 */
public class TestActionListener {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		TestActionListerFrame talf = new TestActionListerFrame();
		talf.setVisible( true );
		talf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}


class TestActionListerFrame extends JFrame {

	private JButton button;

	public TestActionListerFrame() {
		// 设置窗口的布局管理器
		setLayout( new FlowLayout() );

		// 准备组件
		button = new JButton( "点击我" );

		// 给按钮添加监听器
		// button.addActionListener(new MyActionListener());

		button.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				System.out.println( e.getActionCommand() );
			}
		} );

		// 添加
		add( button );

		// 设置大小和显示位置
		setBounds( 420, 160, 300, 300 );
	}

}


class MyActionListener implements ActionListener {

	public void actionPerformed( ActionEvent e ) {

		// 获取按钮上的文本.
		String cmd = e.getActionCommand();

		System.out.println( cmd );
	}

}
