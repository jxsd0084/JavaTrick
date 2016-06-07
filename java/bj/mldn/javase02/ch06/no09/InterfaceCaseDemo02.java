package bj.mldn.javase02.ch06.no09;

interface USB {        // 定义了USB接口

	public void start();    // USB设备开始工作

	public void stop();    // USB设备结束工作
}

class Computer {

	public static void plugin( USB usb ) {    // 电脑上可以插入USB设备
		usb.start();
		System.out.println( "=========== USB 设备工作 ========" );
		usb.stop();
	}
}

class Flash implements USB {

	public void start() {    // 覆写方法
		System.out.println( "U盘开始工作。" );
	}

	public void stop() {        // 覆写方法
		System.out.println( "U盘停止工作。" );
	}
}

class Print implements USB {

	public void start() {    // 覆写方法
		System.out.println( "打印机开始工作。" );
	}

	public void stop() {        // 覆写方法
		System.out.println( "打印机停止工作。" );
	}
}

public class InterfaceCaseDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Computer.plugin( new Flash() );
		Computer.plugin( new Print() );
	}
}
