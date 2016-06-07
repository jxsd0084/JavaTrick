package bj.powernode.basic.day17.线程的第二种实现方式;

/*

	线程的第二种实现方式：常用的实现方式

*/
public class MyRunnable implements Runnable {  //可运行的.

	public void run() {

		for ( int i = 0; i < 100; i++ ) {
			System.out.println( i );
		}
	}


	// 主线程
	public static void main( String[] args ) {

		MyRunnable r = new MyRunnable();

		Thread t1 = new Thread( r );

		t1.start(); // 启动t1线程

		for ( int i = 0; i < 100; i++ ) {

			System.out.println( "!!!!!!" );
		}

	}

}
