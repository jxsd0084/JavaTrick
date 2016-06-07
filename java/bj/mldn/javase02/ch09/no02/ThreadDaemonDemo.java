package bj.mldn.javase02.ch09.no02;

class MyThread3 implements Runnable {    // 实现Runnable接口

	public void run() {                  // 覆写run()方法
		while ( true ) {
			System.out.println( Thread.currentThread().getName() + "在运行。" );
		}
	}
}

public class ThreadDaemonDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread3 mt = new MyThread3();             // 实例化Runnable子类对象
		Thread    t  = new Thread( mt, "线程" );    // 实例化Thread对象
		t.setDaemon( true );                        // 此线程在后台运行
		t.start();                                  // 启动线程
	}
}
