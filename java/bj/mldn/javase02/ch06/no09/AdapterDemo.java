package bj.mldn.javase02.ch06.no09;

interface Window {        // 定义Window接口，表示窗口操作

	public void open();    // 打开

	public void close();    // 关闭

	public void activated();    // 窗口活动

	public void iconified();    // 窗口最小化

	public void deiconified();// 窗口恢复大小
}

abstract class WindowAdapter implements Window {

	public void open() {

	}

	;    // 打开

	public void close() {

	}

	;    // 关闭

	public void activated() {

	}

	;    // 窗口活动

	public void iconified() {

	}

	;    // 窗口最小化

	public void deiconified() {

	}

	;// 窗口恢复大小
}

class WindowImpl extends WindowAdapter {

	public void open() {

		System.out.println( "窗口打开。" );
	}

	public void close() {

		System.out.println( "窗口关闭。" );
	}
}

public class AdapterDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Window win = new WindowImpl();
		win.open();
		win.close();
	}
}
