package bj.powernode.advance.Charpter14.thread.test5;

public class MyThread1 extends Thread {

	public MyThread1( String name ) {

		super( name );
	}

	public void run() {

		for ( int i = 0; i < 100000; i++ ) {
			System.err.println( this.getName() + "=======================i" + i );

			// try {
			if ( i % 100 == 0 && i != 0 ) {
				System.err
						.println( "========================================================"
						          + this.getName() + " 要发扬风格了" );

				// sleep()期间,线程不会进入到就绪队列中,而是睡醒之后,才回到就绪队列中
				// yield()之后,线程马上又回到了就绪队列中

				// Thread.sleep(5000);

				//yield()暂停当前正在执行的线程对象，并执行其他线程 				
				Thread.yield();
			}
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
	}
}
