package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_11_同步计数器_Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 5.11 同步计数器 Semaphore
 */
public class SemaphoreDemo {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {

		final Semaphore semaphore = new Semaphore( 3 );//一次只运行3个人进行访问

		for ( int i = 0; i < 10; i++ ) {

			final int no = i;

			Runnable thread = new Runnable() {
				public void run() {

					try {

						System.out.println( "用户" + no + "连接上了:" );
						Thread.sleep( 300L );

						semaphore.acquire();                // 获取接下去执行的许可

						System.out.println( "用户" + no + "开始访问后台程序..." );
						Thread.sleep( 1000L );              // 模仿用户访问服务过程

						semaphore.release();                // 释放允许下一个线程访问进入后台
						System.out.println( "用户" + no + "访问结束。" );

					} catch ( InterruptedException e ) {
						e.printStackTrace();

					}
				}
			};

			new Thread( thread ).start();
		}

		System.out.println( "Main thread end!" );
	}

}