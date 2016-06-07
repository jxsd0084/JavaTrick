package bj.crazy.ch12.u10;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0
 *          <br>Copyright (C), 2005-2008, yeeku.H.Lee
 *          <br>This program is protected by copyright laws.
 *          <br>Program Name:
 *          <br>Date:
 */
public class ChangeAllCellRender {

	JFrame jf = new JFrame( "改变所有节点的外观" );

	JTree tree;
	//定义几个初始节点
	DefaultMutableTreeNode root      = new DefaultMutableTreeNode( "中国" );
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode( "广东" );
	DefaultMutableTreeNode guangxi   = new DefaultMutableTreeNode( "广西" );
	DefaultMutableTreeNode foshan    = new DefaultMutableTreeNode( "佛山" );
	DefaultMutableTreeNode shantou   = new DefaultMutableTreeNode( "汕头" );
	DefaultMutableTreeNode guilin    = new DefaultMutableTreeNode( "桂林" );
	DefaultMutableTreeNode nanning   = new DefaultMutableTreeNode( "南宁" );


	public void init() throws Exception {
		//通过add方法建立树节点之间的父子关系
		guangdong.add( foshan );
		guangdong.add( shantou );
		guangxi.add( guilin );
		guangxi.add( nanning );
		root.add( guangdong );
		root.add( guangxi );
		//以根节点创建树
		tree = new JTree( root );

		//创建一个DefaultTreeCellRender对象
		DefaultTreeCellRenderer cellRender = new DefaultTreeCellRenderer();
		//设置非选定节点的背景色。 
		cellRender.setBackgroundNonSelectionColor( new Color( 220, 220, 220 ) );
		//设置节点在选中状态下的背景颜色。 
		cellRender.setBackgroundSelectionColor( new Color( 140, 140, 140 ) );
		//设置选中状态下节点的边框颜色。
		cellRender.setBorderSelectionColor( Color.BLACK );
		//设置处于折叠状态下非叶子节点的图标。
		cellRender.setClosedIcon( new ImageIcon( "icon/close.gif" ) );
		//设置节点文本的字体。
		cellRender.setFont( new Font( "SansSerif", Font.BOLD, 16 ) );
		//设置叶子节点的图标。
		cellRender.setLeafIcon( new ImageIcon( "icon/leaf.png" ) );
		//设置处于展开状态下非叶子节点的图标。
		cellRender.setOpenIcon( new ImageIcon( "icon/open.gif" ) );
		//设置绘制非选中状态下节点文本的颜色。
		cellRender.setTextNonSelectionColor( new Color( 255, 0, 0 ) );
		//设置绘制选中状态下节点文本的颜色。
		cellRender.setTextSelectionColor( new Color( 0, 0, 255 ) );

		tree.setCellRenderer( cellRender );

		//设置是否显示根节点的“展开/折叠”图标,默认是false
		tree.setShowsRootHandles( true );
		//设置节点是否可见,默认是true
		tree.setRootVisible( true );


		jf.add( new JScrollPane( tree ) );
		jf.pack();
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jf.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {
		new ChangeAllCellRender().init();
	}
}
