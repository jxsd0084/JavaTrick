package bj.powernode.basic.day17.更好的结束线程的方法;

public class MyRunnable implements Runnable {

	boolean flag = true;

	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			if ( !flag ) {

				return;
			}

			try {

				Thread.sleep( 1000 );
			} catch ( Exception e ) {

				e.printStackTrace();
			}

			System.out.println( i );
		}
	}


	// 主线程.
	public static void main( String[] args ) throws Exception {

		MyRunnable r = new MyRunnable();

		Thread t1 = new Thread( r );





		t1.start();




		Thread.sleep( 3000 );

		r.flag = false;  // 结束线程.

	}

}
