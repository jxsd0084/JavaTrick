package threads.JavaThreadDesign.ch5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable {

	final Semaphore semp = new Semaphore( 5 );

	@Override
	public void run() {

		try {

			semp.acquire();

			//模拟耗时操作
			Thread.sleep( 2000 );

			System.out.println( Thread.currentThread().getId() + ":done!" );

		} catch ( InterruptedException e ) {
			e.printStackTrace();

		} finally {
			semp.release();

		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) {

		ExecutorService exec = Executors.newFixedThreadPool( 20 );

		final SemapDemo demo = new SemapDemo();

		for ( int i = 0; i < 20; i++ ) {

			exec.submit( demo );
		}

	}

}

/*

Java多线程-新特征-信号量Semaphore

URL:    http://www.cnblogs.com/linjiqin/archive/2013/07/25/3214676.html


信号量(Semaphore)，有时被称为信号灯，是在多线程环境下使用的一种设施, 它负责协调各个线程, 以保证它们能够正确、合理的使用公共资源。


*/