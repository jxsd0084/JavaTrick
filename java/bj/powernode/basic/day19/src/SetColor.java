package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

/**
 * 给组件的背景添加颜色
 *
 * @author Administrator
 */
public class SetColor {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		// 第一个窗口

		Frame frame = new Frame( "第一个窗口" );

		frame.setBackground( Color.MAGENTA );

		frame.setSize( 300, 300 );

		frame.setLocation( 120, 160 );

		frame.setVisible( true );


		// 第二个窗口
		JFrame jf = new JFrame( "第二个窗口" );

		// 创建一个面板
		JPanel jp = new JPanel();

		// 设置JPanel的背景色
		// jp.setBackground(Color.BLUE);
		jp.setBackground( new Color( 255, 0, 0 ) );

		jf.setBounds( 420, 160, 300, 300 );


		// 将面板添加到窗体上
		jf.add( jp );

		jf.setVisible( true );

		// 设置窗体不能改变大小
		jf.setResizable( false );

		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}

}
