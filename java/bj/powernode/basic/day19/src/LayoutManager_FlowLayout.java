package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;


/**
 * GUI中的布局管理器
 * java.awt.LayoutManager; <<interface>>
 * 常用的布局管理器：
 * 1. FlowLayout  (流式布局方式)
 * 2. BorderLayout (边框布局方式:east,west,south,north,center)
 * 3. GridLayout (网格布局方式)
 * <p>
 * 4. GridBagLayout (比较复杂)
 * <p>
 * JFrame的默认布局方式: BorderLayout
 * JPanel的默认布局方式：FlowLayout
 * <p>
 * 取消布局方式: jFrame.setLayout(null);
 * jPanel.setLayout(null);
 */
public class LayoutManager_FlowLayout {

	/**
	 * FlowLayout
	 */
	public static void main( String[] args ) {

		TestFlowLayoutFrame tff = new TestFlowLayoutFrame();

		tff.setVisible( true ); //设置可见

		tff.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //关闭时默认执行的操作：退出系统


	}

}


class TestFlowLayoutFrame extends JFrame {

	public TestFlowLayoutFrame() {

		setTitle( "流式布局管理器" );

		// 1.创建布局管理器是 FlowLayout
		FlowLayout flowLayout = new FlowLayout();

		// 2.设置管理器
		setLayout( flowLayout );

		// 3.创建按钮
		for ( int i = 1; i <= 10; i++ ) {
			JButton but = new JButton( i + "" );
			add( but );
		}


		// 4设置大小和在屏幕中显示的位置
		setBounds( 420, 160, 300, 300 );


	}
}



























