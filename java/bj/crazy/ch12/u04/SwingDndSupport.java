package bj.crazy.ch12.u04;

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
public class SwingDndSupport {

	JFrame     jf     = new JFrame( "Swing的拖放支持" );
	JTextArea  srcTxt = new JTextArea( 8, 30 );
	JTextField jtf    = new JTextField( 34 );

	public void init() {
		srcTxt.append( "AWT的拖放支持.\n" );
		srcTxt.append( "将该文本域的内容拖入其他程序.\n" );
		//启动文本域和单行文本框的拖放支持
		srcTxt.setDragEnabled( true );
		jtf.setDragEnabled( true );
		jf.add( new JScrollPane( srcTxt ) );
		jf.add( jtf, BorderLayout.SOUTH );
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jf.pack();
		jf.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new SwingDndSupport().init();
	}
}
