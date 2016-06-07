package threads.JavaThreadCookBook.ch02_认识Java里面的Thread.demo1_第一种创建线程的方式_extends_Thread;

/**
 * @author jack
 */
public class ThreadMain {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ThreadA threada = new ThreadA();

		threada.start();

		System.out.println( "这是主线程；" );

	}

}
