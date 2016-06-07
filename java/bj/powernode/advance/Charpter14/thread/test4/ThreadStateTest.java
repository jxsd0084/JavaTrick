package bj.powernode.advance.Charpter14.thread.test4;

public class ThreadStateTest extends Thread {

	// 重写run方法
	public void run() {

		try {

			// 局部变量i从0到30循环,每到10的整数倍时让线程睡上5秒钟
			for ( int i = 0; i <= 30; i++ ) {
				// 判断是不是10的整数倍并且除数不能为0
				if ( i % 10 == 0 && i != 0 ) {
					System.out.println( "在sleep之前"

					                    // currentThread()返回对当前正在执行的线程对象的引用 isAlive()测试线程是否处于活动状态
					                    + Thread.currentThread().isAlive() );

					Thread.sleep( 5000 );

					System.out.println( "在sleep之后"

					                    // currentThread()返回对当前正在执行的线程对象的引用 isAlive()测试线程是否处于活动状态
					                    + Thread.currentThread().isAlive() );
				}

				System.out.println( "No." + i );
			}
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}

	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// 创建线程对象并启动
		ThreadStateTest thread = new ThreadStateTest();
		thread.start();
	}

}
