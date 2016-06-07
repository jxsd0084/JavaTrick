package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._597_创建视图;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyJPanel extends JPanel {

	public MyJPanel() {

		super();
	}

	public void paintComponent( Graphics g ) {

		try {
			URL       url   = getClass().getResource( "bg.jpg" ); // 指定图片路径
			ImageIcon image = new ImageIcon( url ); // 创建ImageIcon对象
			g.drawImage( image.getImage(), 0, 0, this ); // 绘制图片
		} catch ( Exception e ) {
		}
	}
}
