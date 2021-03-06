package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_9_同步计数器_CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 5.9 同步计数器 CountDownLatch
 */
public class CountDownLatchDemo {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {

		CountDownLatch latch = new CountDownLatch( 3 );

		Worker worker1 = new Worker( "Jack 程序员1", latch );
		Worker worker2 = new Worker( "Rose 程序员2", latch );
		Worker worker3 = new Worker( "Json 程序员3", latch );

		worker1.start();
		worker2.start();
		worker3.start();

		latch.await();

		System.out.println( "Main thread end!" );

	}

	static class Worker extends Thread {

		private String         workerName;
		private CountDownLatch latch;

		public Worker( String workerName, CountDownLatch latch ) {

			this.workerName = workerName;
			this.latch = latch;
		}

		@Override
		public void run() {

			try {

				System.out.println( "Worker:" + workerName + " is begin." );

				Thread.sleep( 1000L );

				System.out.println( "Worker:" + workerName + " is end." );

			} catch ( InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}   // 模仿干活；

			latch.countDown();
		}

	}

}