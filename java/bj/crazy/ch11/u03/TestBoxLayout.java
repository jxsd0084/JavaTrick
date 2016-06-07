package bj.crazy.ch11.u03;

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
public class TestBoxLayout {

	private Frame f = new Frame( "测试" );

	public void init() {
		f.setLayout( new BoxLayout( f, BoxLayout.Y_AXIS ) );
		f.add( new Button( "第一个按钮" ) );
		f.add( new Button( "按钮二" ) );
		f.pack();
		f.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new TestBoxLayout().init();
	}
}
