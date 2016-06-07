package bj.powernode.advance.Charpter14.thread.test5;

public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建线程对象
		MyThread1 mt1 = new MyThread1( "正循环线程" );
		MyThread2 mt2 = new MyThread2( "反循环线程" );

		// 启动线程对象
		mt1.start();
		mt2.start();
	}

}
