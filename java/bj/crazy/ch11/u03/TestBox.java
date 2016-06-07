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
public class TestBox {

	private Frame f          = new Frame( "测试" );
	//定义水平摆放组件的Box对象
	private Box   horizontal = Box.createHorizontalBox();
	//定义垂直摆放组件的Box对象
	private Box   vertical   = Box.createVerticalBox();

	public void init() {
		horizontal.add( new Button( "水平按钮一" ) );
		horizontal.add( new Button( "水平按钮二" ) );
		vertical.add( new Button( "垂直按钮一" ) );
		vertical.add( new Button( "垂直按钮二" ) );
		f.add( horizontal, BorderLayout.NORTH );
		f.add( vertical );
		f.pack();
		f.setVisible( true );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		new TestBox().init();
	}
}