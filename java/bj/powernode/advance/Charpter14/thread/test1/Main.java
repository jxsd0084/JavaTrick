package bj.powernode.advance.Charpter14.thread.test1;

// main类进行测试
public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建线程对象并用start方法启动线程
		// 创建线程类对象1
		MyThread1 mt1 = new MyThread1( "正循环线程" );
		// 创建线程类对象2
		MyThread2 mt2 = new MyThread2( "反循环线程" );

		// 启动线程1和2
		mt1.start();
		mt2.start();

	}

}
