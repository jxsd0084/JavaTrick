package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

/**
 * java.awt.Panel
 * javax.swing.JPanel
 *
 * @author Administrator
 */
public class Panel01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		JFrame jf = new JFrame( "窗体中央有一个黄色面板" );

		// 默认的JFrame和Frame都有一个默认的布局管理器. (JFrame和Frame默认的布局管理器 BorderLayout)
		// 将默认的布局管理器去除
		jf.setLayout( null );


		// 1.准备一个面板
		// JPanel的默认布局管理器是 FlowLayout
		JPanel jp = new JPanel();

		// 2.设置面板的背景颜色
		jp.setBackground( Color.YELLOW );

		// 3.设置面板的大小
		jp.setSize( 100, 100 );


		// 4.设置面板在主窗口中出现的位置.
		jp.setLocation( 100, 50 );

		jf.setBounds( 420, 160, 300, 200 );

		jf.setVisible( true );


		// 5.将面板添加到主窗体
		jf.add( jp );

		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
