package bj.Java1200.col01.ch03_数组与集合应用.ch03_4_常用集合的使用._059_Map映射集合实现省市级联选择框;

import javax.swing.*;
import java.awt.*;

/**
 * 带背景的面板组件
 * 
 * @author ZhongWei Lee
 */
public class BackgroundPanel extends JPanel {

	/**
	 * 背景图片
	 */
	private Image image;

	/**
	 * 构造方法
	 */
	public BackgroundPanel() {
		super();
		setOpaque(false);
		setLayout(null);
	}

	/**
	 * 设置图片的方法
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {// 重写绘制组件外观
		if (image != null) {
			int width = getWidth();// 获取组件大小
			int height = getHeight();
			g.drawImage(image, 0, 0, width, height, this);// 绘制图片与组件大小相同
		}
		super.paintComponent(g);// 执行超类方法
	}
}
