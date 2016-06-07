package bj.powernode.advance.Charpter14.thread.test2;

public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建目标对象
		Target1 t1 = new Target1();
		Target2 t2 = new Target2();

		// 将目标对象传给创建出来的线程对象
		Thread th1 = new Thread( t1, "正循环线程" );
		Thread th2 = new Thread( t2, "反循环线程" );

		// 调用start方法启动线程
		th1.start();
		th2.start();

	}

}
