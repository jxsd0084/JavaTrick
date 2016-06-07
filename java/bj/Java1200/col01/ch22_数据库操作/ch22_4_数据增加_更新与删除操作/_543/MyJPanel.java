package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._543;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyJPanel extends JPanel {

	public MyJPanel() {

		super();
	}

	public void paintComponent( Graphics g ) {

		try {
			URL       url   = getClass().getResource( "/images/enter.jpg" ); // 指定图片路径
			ImageIcon image = new ImageIcon( url ); // 创建ImageIcon对象
			g.drawImage( image.getImage(), 0, 0, this ); // 将图片绘制到面板上

		} catch ( Exception e ) {
		}
	}
}
