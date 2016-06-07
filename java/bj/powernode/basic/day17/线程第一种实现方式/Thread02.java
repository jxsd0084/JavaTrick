package bj.powernode.basic.day17.线程第一种实现方式;

/*

	直接调用run方法和通过启动线程来调用run方法有什么区别.

*/
public class Thread02 extends Thread {  // Thread02是一个线程类.

	// Thread02的构造方法.
	public Thread02( String s ) {       // s是线程的名字.
		super( s );
	}

	// 重写run方法.
	public void run() {

		// getName方法获取线程的名字.
		for ( int i = 0; i < 100; i++ ) {

			System.out.println( getName() + "=" + i );
		}

	}


	// 主线程
	public static void main( String[] args ) {

		Thread02 t1 = new Thread02( "abcde" );
		// t1.start();

		t1.run();


		for ( int i = 0; i < 100; i++ ) {

			System.out.println( i );
		}

	}

}
