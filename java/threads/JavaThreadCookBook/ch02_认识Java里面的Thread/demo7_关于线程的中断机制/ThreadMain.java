package threads.JavaThreadCookBook.ch02_认识Java里面的Thread.demo7_关于线程的中断机制;

public class ThreadMain {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ThreadB task   = new ThreadB();
		Thread  thread = new Thread( task );

		thread.setUncaughtExceptionHandler( new ExceptionHandlerThreadB() );

		thread.start();

	}

}
