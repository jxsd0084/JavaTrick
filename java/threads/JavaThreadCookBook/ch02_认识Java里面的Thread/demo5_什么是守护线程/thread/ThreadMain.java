package threads.JavaThreadCookBook.ch02_认识Java里面的Thread.demo5_什么是守护线程.thread;

public class ThreadMain {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Thread tA = new ThreadA();
		Thread tB = new ThreadB();

		tA.setDaemon( true ); // 设置为守护线程,注意一定要在开始之前调用

		tB.start();
		tA.start();

		Thread mainThread = Thread.currentThread();

		System.out.println( "线程A是不是守护线程" + tA.isDaemon() );
		System.out.println( "线程b是不是守护线程" + tB.isDaemon() );
		System.out.println( "线程main是不是守护线程" + mainThread.isDaemon() );

	}

}

/*

线程B第0次执行！
后台线程A第0次执行！
线程A是不是守护线程true
线程b是不是守护线程false
线程main是不是守护线程false
线程B第1次执行！
后台线程A第1次执行！
后台线程A第2次执行！
线程B第2次执行！
后台线程A第3次执行！
线程B第3次执行！
后台线程A第4次执行！
线程B第4次执行！
后台线程A第5次执行！

Process finished with exit code 0




 */
