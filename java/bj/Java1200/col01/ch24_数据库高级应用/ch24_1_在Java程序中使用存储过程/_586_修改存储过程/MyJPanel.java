package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._586_修改存储过程;

import java.awt.Graphics;
import java.net.URL;
import javax.swing.*;

public class MyJPanel extends JPanel {

	public MyJPanel() {

		super();
	}

	public void paintComponent( Graphics g ) {

		try {
			URL       url   = getClass().getResource( "registerbg.gif" ); // 指定图片路径
			ImageIcon image = new ImageIcon( url ); // 创建ImageIcon对象
			g.drawImage( image.getImage(), 0, 0, this ); // 绘制图片
		} catch ( Exception e ) {
		}
	}
}
