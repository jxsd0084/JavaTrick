package bj.powernode.basic.day20.mouse;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * 练习内容：
 * 1. JLabel
 * 2. 适配器的使用
 * 3. MouseListener
 *
 * @author Administrator
 */
public class SaoLei extends JFrame {

	private JPanel msgPanel, leiQuPanel;

	private JLabel msg;  // 这个组件上可以写字儿


	// 非静态成员内部类
	class MyMouseListener extends AbstractMouseListener {

		public void mouseEntered( MouseEvent e ) {
			msg.setText( "您已进入雷区，请小心操作!" );
		}

		public void mouseExited( MouseEvent e ) {
			msg.setText( "" );
		}


	}

	public SaoLei() {

		setTitle( "扫雷" );

		setLayout( null );  // 不使用任何布局方式

		msg = new JLabel();
		msgPanel = new JPanel();
		leiQuPanel = new JPanel();

		// 给雷区面板添加监听
		leiQuPanel.addMouseListener( new MyMouseListener() );

		msgPanel.setBounds( 100, 50, 200, 30 );
		leiQuPanel.setBounds( 100, 100, 200, 200 );

		add( msgPanel );
		add( leiQuPanel );
		msgPanel.add( msg );

		setBounds( 420, 160, 400, 400 );

	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		SaoLei saoLei = new SaoLei();

		saoLei.setVisible( true );

		saoLei.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
