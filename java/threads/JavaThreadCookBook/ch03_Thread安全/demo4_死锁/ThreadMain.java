package threads.JavaThreadCookBook.ch03_Thread安全.demo4_死锁;

public class ThreadMain {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Count count = new Count();

		ThreadA task = new ThreadA( count );

		task.setName( "线程A" );
		task.start();


		ThreadB taskB = new ThreadB( count );

		taskB.setName( "线程B" );
		taskB.start();

	}

}
