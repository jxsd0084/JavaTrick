package bj.mldn.javase01.no42.sleepdemo;

public class MyThread implements Runnable {

	public void run() {

		for ( int i = 0; i < 10; i++ ) {
			try {
				Thread.sleep( 500 ); // 每个休眠500毫秒

			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}

			System.out.println( Thread.currentThread().getName() + "线程正在运行。" );
		}

	}

}
