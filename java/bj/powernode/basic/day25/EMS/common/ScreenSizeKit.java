package bj.powernode.basic.day25.EMS.common;

import java.awt.*;

/**
 * 屏幕尺寸工具,通过该工具可以快速获取屏幕的宽度和高度
 *
 * @author Administrator
 */
public class ScreenSizeKit {

	private static Toolkit   kit;
	private static Dimension screenSize;

	static {
		kit = Toolkit.getDefaultToolkit();
		screenSize = kit.getScreenSize();
	}

	public static int getWidth() {

		return screenSize.width;
	}

	public static int getHeight() {

		return screenSize.height;
	}
}
