package bj.crazy.ch11.u05;

import java.awt.*;
import java.awt.event.*;

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
public class EventQs {

	private Frame     f  = new Frame( "测试事件" );
	private Button    ok = new Button( "确定" );
	private TextField tf = new TextField( 30 );

	public void init() {
		//注册事件监听器
		ok.addActionListener( new OkListener() );
		f.add( tf );
		f.add( ok, BorderLayout.SOUTH );
		f.pack();
		f.setVisible( true );
	}

	//定义事件监听器类
	class OkListener implements ActionListener {

		//下面定义的方法就是事件处理器，用于响应特定的事件
		public void actionPerformed( ActionEvent e ) {
			System.out.println( "用户单击了ok按钮" );
			tf.setText( "Hello World" );
		}
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new EventQs().init();
	}
}
