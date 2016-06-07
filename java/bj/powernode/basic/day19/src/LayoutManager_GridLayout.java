package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

/**
 * GridLayout 网格布局方式(几行几列)
 *
 * @author Administrator
 */
public class LayoutManager_GridLayout {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		TestGridLayoutFrame tglf = new TestGridLayoutFrame();
		tglf.setVisible( true );
		tglf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}

class TestGridLayoutFrame extends JFrame {

	private JButton b1, b2, b3, b4, b5, b6;

	public TestGridLayoutFrame() {
		setTitle( "网格布局管理器" );

		// 设置布局管理器(3行2列)
		setLayout( new GridLayout( 3, 2 ) );


		// 准备组件
		b1 = new JButton( "A" );
		b2 = new JButton( "B" );
		b3 = new JButton( "C" );
		b4 = new JButton( "D" );
		b5 = new JButton( "E" );
		b6 = new JButton( "F" );


		// 添加组件
		add( b1 );
		add( b2 );
		add( b3 );
		add( b4 );
		add( b5 );
		add( b6 );


		// 设置大小和显示位置
		setBounds( 420, 160, 300, 300 );
	}
}
