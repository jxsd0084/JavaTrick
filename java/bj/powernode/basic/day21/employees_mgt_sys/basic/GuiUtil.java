package bj.powernode.basic.day21.employees_mgt_sys.basic;

import java.awt.*;

public class GuiUtil {

	private static Toolkit   kit;
	private static Dimension screenSize;

	static {
		kit = Toolkit.getDefaultToolkit();
		screenSize = kit.getScreenSize();
	}

	public static int getScreenWidth() {

		return screenSize.width;
	}

	public static int getScreenHeight() {

		return screenSize.height;
	}

	public static Image getImage( String filename ) {

		return kit.getImage( filename );
	}
}
