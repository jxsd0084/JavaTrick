package bj.mldn.javase01.no42.prioritydemo;

class MyThread implements Runnable {

	public void run() {

		for ( int i = 0; i < 10; i++ ) {
			try {
				Thread.sleep( 600 );    // 延迟操作
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
			System.out.println( Thread.currentThread().getName() + "线程正在运行。" );
		}
	}
}

public class PriorityDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyThread mt = new MyThread();

		Thread   t1 = new Thread( mt, "线程A" );
		Thread   t2 = new Thread( mt, "线程B" );
		Thread   t3 = new Thread( mt, "线程C" );

		t1.setPriority( Thread.NORM_PRIORITY );  // 将第一个线程设置为中等优先级
		t3.setPriority( Thread.MAX_PRIORITY );   // 将第三个线程设置为最高优先级
		t2.setPriority( Thread.MIN_PRIORITY );   // 将第二个线程设置为最低优先级

		t1.start();
		t2.start();
		t3.start();

	}
}
