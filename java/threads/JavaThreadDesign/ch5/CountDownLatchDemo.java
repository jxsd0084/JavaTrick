package threads.JavaThreadDesign.ch5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {

	static final CountDownLatch     end  = new CountDownLatch( 10 );
	static final CountDownLatchDemo demo = new CountDownLatchDemo();

	@Override
	public void run() {

		try {

			// 模拟检查任务
			Thread.sleep( new Random().nextInt( 10 ) * 1000 );

			System.out.println( "check complete" );

			end.countDown();

		} catch ( InterruptedException e ) {

			e.printStackTrace();
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		ExecutorService exec = Executors.newFixedThreadPool( 10 );

		for ( int i = 0; i < 10; i++ ) {

			exec.submit( demo );
		}

		// 等待检查
		end.await();

		// 发射火箭
		System.out.println( "Fire!" );

		exec.shutdown();

	}

}

/*

什么时候使用CountDownLatch?

URL:    http://www.importnew.com/15731.html

CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。

在Java并发中，countdownlatch的概念是一个常见的面试题，所以一定要确保你很好的理解了它。


CountDownLatch是在java1.5被引入的，跟它一起被引入的并发工具类还有

CyclicBarrier、Semaphore、ConcurrentHashMap和BlockingQueue，它们都存在于java.util.concurrent包下。

CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行。

*/

