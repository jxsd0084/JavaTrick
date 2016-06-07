package threads.JavaThreadCookBook.ch02_认识Java里面的Thread.demo5_什么是守护线程.thread;

public class ThreadB extends Thread {

	public void run() {

		for ( int i = 0; i < 5; i++ ) {

			System.out.println( "线程B第" + i + "次执行！" );

			try {

				Thread.sleep( 7 );

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			}

		}

	}

}
