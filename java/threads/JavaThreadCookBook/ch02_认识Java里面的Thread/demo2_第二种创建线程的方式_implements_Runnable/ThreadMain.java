package threads.JavaThreadCookBook.ch02_认识Java里面的Thread.demo2_第二种创建线程的方式_implements_Runnable;

public class ThreadMain {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ThreadB threadb = new ThreadB();

		new Thread( threadb ).start(); // 注意启动方式有点不一样；

		System.out.println( "这是主线程；" );

	}

}
