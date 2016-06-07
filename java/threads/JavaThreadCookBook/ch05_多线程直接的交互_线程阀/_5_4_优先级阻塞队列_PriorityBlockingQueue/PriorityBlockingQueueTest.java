package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_4_优先级阻塞队列_PriorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 5.4 优先级阻塞队列 PriorityBlockingQueue
 */
public class PriorityBlockingQueueTest {

	private static int COUNT      = 100;
	private static int THREAD_NUM = 10;

	static class Producer extends Thread {

		private BlockingQueue queue;
		private Random rnd = new Random();

		public Producer( BlockingQueue queue ) {

			this.queue = queue;
		}

		public void run() {

			for ( int i = 0; i < COUNT; i++ ) {

				try {
					int n = rnd.nextInt( COUNT );
					queue.put( new Entity( n ) );
					System.err.println( "Producer.run()" + n );
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Customer extends Thread {

		private BlockingQueue queue;

		public Customer( BlockingQueue queue ) {

			this.queue = queue;
		}

		public void run() {

			for ( int i = 0; i < COUNT; i++ ) {
				try {
					Entity e = ( Entity ) queue.take();
					System.out.println( "Customer.run()" + e.getSize() );
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Entity implements Comparable< Entity > {

		private int size;

		public Entity( int size ) {

			this.size = size;
		}

		public int getSize() {

			return size;
		}

		public int compareTo( Entity o ) {

			return this.size > o.size ? 1 : ( ( this.size == o.size ) ? 0 : -1 );
		}

	}

	private static PriorityBlockingQueue< Entity > queue = new PriorityBlockingQueue< Entity >();

	public static long getQueuePerformanceTest( BlockingQueue queue,
	                                            int threadNum ) throws InterruptedException {

		long     start     = System.nanoTime();
		Thread[] producers = new Producer[ threadNum ];
		Thread[] customers = new Customer[ threadNum ];

		for ( int i = 0; i < threadNum; i++ ) {
			producers[ i ] = new Producer( queue );
			producers[ i ].start();
			customers[ i ] = new Customer( queue );
			customers[ i ].start();
		}

		for ( int i = 0; i < threadNum; i++ ) {
			producers[ i ].join();
			customers[ i ].join();
		}

		long end = System.nanoTime();
		return ( end - start );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			getQueuePerformanceTest( queue, THREAD_NUM );

		} catch ( InterruptedException e ) {
			e.printStackTrace();

		}

	}

}

/*

BlockingQueue、PriorityBlockingQueue

URL:    http://blog.csdn.net/i_lovefish/article/details/26145139


PriorityBlockingQueue 的一个例子

URL:    http://blog.csdn.net/arkblue/article/details/6147090


 */