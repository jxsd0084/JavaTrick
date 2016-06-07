package threads.JavaThreadCookBook.ch09_线程的监控及其日常工作中如何分析._9_MultiThreadTC测试并发介绍;

import edu.umd.cs.mtc.MultithreadedTestCase;
import edu.umd.cs.mtc.TestFramework;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by Administrator on 2016/6/5.
 */
public class ProducerConsumerTest extends MultithreadedTestCase {

	private LinkedTransferQueue< String > queue;

	public void initialize() {

		super.initialize();
		queue = new LinkedTransferQueue< String >();
		System.out.println( "Test : The test has been initialized\n" );
	}

	public void thread1() throws InterruptedException {

		String ret = queue.take();
		System.out.printf( "Thread 1 : %s\n", ret );
	}

	public void thread2() throws InterruptedException {

		waitForTick( 1 );
		String ret = queue.take();
		System.out.printf( "Thread 2 : %s\n", ret );
	}

	public void thread3() {

		waitForTick( 1 );
		waitForTick( 2 );
		queue.put( "Event 1" );
		queue.put( "Event 2" );
		System.out.println( "Thread 3 : Inserted two elements\n" );
	}

	public void finish() {

		super.finish();
		System.out.printf( "Test : End\n" );
		assertEquals( true, queue.size() == 0 );
		System.out.println( "Test : Result: The queue is empty\n" );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		ProducerConsumerTest test = new ProducerConsumerTest();
		System.out.printf( "Main : Starting the test\n" );
		try {
			TestFramework.runOnce( test );
		} catch ( Throwable throwable ) {
			throwable.printStackTrace();
		}

		System.err.printf( "Main : The test has finished\n" );
	}

}
