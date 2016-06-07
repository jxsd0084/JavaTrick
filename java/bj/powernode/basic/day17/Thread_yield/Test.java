package bj.powernode.basic.day17.Thread_yield;

/*

	Thread.yield();让当前线程让位给其他线程执行.

*/
public class Test {

	// 主线程.
	public static void main( String[] args ) {

		Thread01 t1 = new Thread01();

		t1.start();

		for ( int i = 0; i <= 100; i++ ) {

			System.out.println( Thread.currentThread().getName() + "--->" + i );
		}

	}
}


class Thread01 extends Thread {

	public void run() {

		for ( int i = 1; i <= 100; i++ ) {

			System.out.println( Thread.currentThread().getName() + "===>" + i );

			if ( i % 10 == 0 ) {

				Thread.yield(); // 让位
			}

		}

	}

}
