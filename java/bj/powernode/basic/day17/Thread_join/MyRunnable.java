package bj.powernode.basic.day17.Thread_join;

public class MyRunnable implements Runnable {


	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );
			} catch ( Exception e ) {

				e.printStackTrace();
			}

			System.out.println( Thread.currentThread().getName() + "--->" + i );

		}

	}


	//主线程
	public static void main( String[] args ) throws Exception {

		MyRunnable r = new MyRunnable();

		Thread t1 = new Thread( r );

		t1.start();

		for ( int i = 0; i < 5; i++ ) {

			Thread.sleep( 1000 );

			System.out.println( "**********" );
		}

		t1.join();  // 将t1线程合并到主线程中 (基本上等同于方法调用)


		// 属于主线程
		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );
			} catch ( Exception e ) {

				e.printStackTrace();
			}

			System.out.println( Thread.currentThread().getName() + "--->" + i );
		}

	}

}
