package bj.crazy.ch11.u05;

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
public class SendMailer {

	private Frame     f    = new Frame( "测试" );
	private TextField tf   = new TextField( 40 );
	private Button    send = new Button( "发送" );

	public void init() {
		send.addActionListener( new MailerListener( tf ) );
		f.add( tf );
		f.add( send, BorderLayout.SOUTH );
		f.pack();
		f.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new SendMailer().init();
	}
}
