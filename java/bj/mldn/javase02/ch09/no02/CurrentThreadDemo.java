package bj.mldn.javase02.ch09.no02;

class MyThread implements Runnable {    // 实现Runnable接口

	public void run() {                 // 覆写run()方法
		for ( int i = 0; i < 3; i++ ) {
			System.out.println( Thread.currentThread().getName()
			                    + "运行，i = " + i );    // 取得当前线程的名字
		}
	}
}

public class CurrentThreadDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread mt = new MyThread();           // 实例化Runnable子类对象
		new Thread( mt, "线程" ).start();        // 启动线程
		mt.run();                               // 直接调用run()方法
	}
}
