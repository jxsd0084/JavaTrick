package threads.JavaThreadCookBook.ch06_线程池._4_newFixedThreadPool的使用;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/6/5.
 */
public class newFixedThreadPoolTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		ExecutorService executor = Executors.newFixedThreadPool( 5 );
		for ( int i = 0; i < 20; i++ ) {
			final int no = i;
			Runnable runnable = new Runnable() {

				@Override
				public void run() {

					try {

						System.out.println( "into" + no );
						Thread.sleep( 1000L );
						System.out.println( "end" + no );
					} catch ( Exception e ) {
						e.printStackTrace();

					}
				}
			};
			executor.execute( runnable );
		}
		executor.shutdown();
		System.out.println( "Thread Main End !" );
	}
	
}
