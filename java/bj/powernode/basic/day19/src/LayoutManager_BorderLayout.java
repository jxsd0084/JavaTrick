package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

/**
 * GUI 的布局管理器: BorderLayout (边框布局方式)
 *
 * @author Administrator
 *         <p>
 *         特点：纵向拉伸: 南和北高度不变.中的高度变
 *         横向拉伸: 东和西的宽度不变，中的宽度变.
 */
public class LayoutManager_BorderLayout {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		TestBorderLayoutFrame tblf = new TestBorderLayoutFrame();
		tblf.setVisible( true );
		tblf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}


class TestBorderLayoutFrame extends JFrame {

	private JButton eastButton, southButton, westButton, northButton, centerButton;

	public TestBorderLayoutFrame() {

		setTitle( "边框布局管理器" );

		// 关联边框布局管理器
		setLayout( new BorderLayout() );

		//准备组件
		eastButton = new JButton( "东" );
		southButton = new JButton( "南" );
		westButton = new JButton( "西" );
		northButton = new JButton( "北" );
		centerButton = new JButton( "中" );

		// 添加组件
		add( eastButton, BorderLayout.EAST );
		add( southButton, BorderLayout.SOUTH );
		add( westButton, BorderLayout.WEST );
		add( northButton, BorderLayout.NORTH );
		add( centerButton, BorderLayout.CENTER );


		// 设置大小和显示位置
		setBounds( 420, 160, 300, 300 );

	}
}
