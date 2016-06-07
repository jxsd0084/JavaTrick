package bj.crazy.ch12.u03;

import javax.swing.*;
import java.awt.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestJLayeredPane {

	JFrame       jf          = new JFrame( "测试JLayeredPane" );
	JLayeredPane layeredPane = new JLayeredPane();

	public void init() {
		//向layeredPane中添加3个组件
		layeredPane.add( new ContentPanel( 10, 20, "Struts2权威指南",
				"ico/struts2.jpg" ), JLayeredPane.MODAL_LAYER );
		layeredPane.add( new ContentPanel( 100, 60, "RoR敏捷开发最佳实践",
				"ico/ror.jpg" ), JLayeredPane.DEFAULT_LAYER );
		layeredPane.add( new ContentPanel( 190, 100, "轻量级J2EE企业应用实战",
				"ico/j2ee.jpg" ), 4 );
		layeredPane.setPreferredSize( new Dimension( 400, 300 ) );
		layeredPane.setVisible( true );
		jf.add( layeredPane );
		jf.pack();
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jf.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new TestJLayeredPane().init();
	}
}

//扩展了JPanel类，可以直接创建一个放在指定位置，
//且有指定标题、放置指定图标的JPanel对象
class ContentPanel extends JPanel {

	public ContentPanel( int xPos, int yPos, String title, String ico ) {
		setBorder( BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), title ) );
		JLabel label = new JLabel( new ImageIcon( ico ) );
		add( label );
		setBounds( xPos, yPos, 160, 200 );
	}
}
