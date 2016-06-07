
package threads.JavaThreadDesign.ch6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtThreadPool {

	public static class MyTask implements Runnable {

		public String name;

		public MyTask( String name ) {

			this.name = name;
		}

		@Override
		public void run() {

			System.out.println( "正在执行" + ":Thread ID:" +
			                    Thread.currentThread().getId() + ",Task Name=" + name );
			try {

				Thread.sleep( 100 );

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			}
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		ExecutorService es = new ThreadPoolExecutor( 5, 5, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue< Runnable >() ) {

			@Override
			protected void beforeExecute( Thread t, Runnable r ) {

				System.out.println( "准备执行：" + ( (MyTask) r ).name );
			}

			@Override
			protected void afterExecute( Runnable r, Throwable t ) {

				System.out.println( "执行完成：" + ( (MyTask) r ).name );
			}

			@Override
			protected void terminated() {

				System.out.println( "线程池退出" );
			}

		};

		for ( int i = 0; i < 5; i++ ) {

			MyTask task = new MyTask( "TASK-GEYM-" + i );

			es.execute( task );

			Thread.sleep( 10 );
		}

		es.shutdown();
	}

}

/*

Java多线程之ExecutorService

URL:    http://blog.csdn.net/a999wt/article/details/8541217

而在Java 5.0里提供了一个新的任务执行架构使我们可以很轻松地调度和控制任务的执行。

这个架构主要有三个接口和其相应的类组成。

这三个接口分别是:Executor、ExevutirService和ScheduledExecutorService。

*/