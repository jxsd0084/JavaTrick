package bj.powernode.basic.day19.src;

import java.awt.*;

/**
 * 如何获取当前计算机屏幕的尺寸(宽和高)
 *
 * @author Administrator
 */
public class ScreenSize {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		// Toolkit GUI的工具箱
		Toolkit kit = Toolkit.getDefaultToolkit();

		// 获得屏幕尺寸
		Dimension screenSize = kit.getScreenSize();

		// 获取宽度
		int width  = screenSize.width;
		int height = screenSize.height;

		System.out.println( "屏幕的宽度是" + width + "像素" );
		System.out.println( "屏幕的高度是" + height + "像素" );

	}

}
