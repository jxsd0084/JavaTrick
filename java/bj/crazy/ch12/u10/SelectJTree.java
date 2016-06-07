package bj.crazy.ch12.u10;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0
 *          <br>Copyright (C), 2005-2008, yeeku.H.Lee
 *          <br>This program is protected by copyright laws.
 *          <br>Program Name:
 *          <br>Date:
 */
public class SelectJTree {

	JFrame jf = new JFrame( "监听树的选择事件" );

	JTree tree;
	//定义几个初始节点
	DefaultMutableTreeNode root      = new DefaultMutableTreeNode( "中国" );
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode( "广东" );
	DefaultMutableTreeNode guangxi   = new DefaultMutableTreeNode( "广西" );
	DefaultMutableTreeNode foshan    = new DefaultMutableTreeNode( "佛山" );
	DefaultMutableTreeNode shantou   = new DefaultMutableTreeNode( "汕头" );
	DefaultMutableTreeNode guilin    = new DefaultMutableTreeNode( "桂林" );
	DefaultMutableTreeNode nanning   = new DefaultMutableTreeNode( "南宁" );

	JTextArea eventTxt = new JTextArea( 5, 20 );

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
		//设置只能选择一个TreePath
		tree.getSelectionModel().setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION );
		//添加监听树节点选择事件的监听器
		tree.addTreeSelectionListener( new TreeSelectionListener() {
			//当JTree中被选择节点发生改变时，将触发该方法
			public void valueChanged( TreeSelectionEvent e ) {

				if ( e.getOldLeadSelectionPath() != null ) {
					eventTxt.append( "原选中的节点路径：" + e.getOldLeadSelectionPath().toString() + "\n" );
				}
				eventTxt.append( "新选中的节点路径：" + e.getNewLeadSelectionPath().toString() + "\n" );
			}
		} );


		//设置是否显示根节点的“展开/折叠”图标,默认是false
		tree.setShowsRootHandles( true );
		//设置节点是否可见,默认是true
		tree.setRootVisible( true );

		Box box = new Box( BoxLayout.X_AXIS );
		box.add( new JScrollPane( tree ) );
		box.add( new JScrollPane( eventTxt ) );
		jf.add( box );
		jf.pack();
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jf.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new SelectJTree().init();
	}
}
