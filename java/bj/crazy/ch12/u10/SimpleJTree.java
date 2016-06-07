package bj.crazy.ch12.u10;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0
 *          <br>Copyright (C), 2005-2008, yeeku.H.Lee
 *          <br>This program is protected by copyright laws.
 *          <br>Program Name:
 *          <br>Date:
 */
public class SimpleJTree {

	JFrame jf = new JFrame( "简单树" );

	JTree tree;
	//定义几个初始节点
	DefaultMutableTreeNode root      = new DefaultMutableTreeNode( "中国" );
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode( "广东" );
	DefaultMutableTreeNode guangxi   = new DefaultMutableTreeNode( "广西" );
	DefaultMutableTreeNode foshan    = new DefaultMutableTreeNode( "佛山" );
	DefaultMutableTreeNode shantou   = new DefaultMutableTreeNode( "汕头" );
	DefaultMutableTreeNode guilin    = new DefaultMutableTreeNode( "桂林" );
	DefaultMutableTreeNode nanning   = new DefaultMutableTreeNode( "南宁" );

	public void init() {
		//通过add方法建立树节点之间的父子关系
		guangdong.add( foshan );
		guangdong.add( shantou );
		guangxi.add( guilin );
		guangxi.add( nanning );
		root.add( guangdong );
		root.add( guangxi );
		//以根节点创建树
		tree = new JTree( root );

		//默认连线
		//tree.putClientProperty("JTree.lineStyle" , "Angeled");
		//没有连线
		tree.putClientProperty( "JTree.lineStyle", "None" );
		//水平分隔线
		//tree.putClientProperty("JTree.lineStyle" , "Horizontal"); 


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
	public static void main( String[] args ) {
		new SimpleJTree().init();
	}
}
