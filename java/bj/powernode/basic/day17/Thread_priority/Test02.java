package bj.powernode.basic.day17.Thread_priority;

public class Test02 {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Thread t1 = new Thread0201();

		Thread t2 = new Thread0202();


		Thread.sleep( 1000 );

		t1.start();

		t2.start();

		Thread.sleep( 5200 );





		System.out.println( "============================" );





		t1.setPriority( 1 );

		t2.setPriority( 10 );


	}

}

class Thread0201 extends Thread {

	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );

			} catch ( Exception e ) {
			}

			System.out.println( Thread.currentThread().getName() );//Thread-0
		}

	}
}


class Thread0202 extends Thread {

	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );

			} catch ( Exception e ) {
			}

			System.out.println( Thread.currentThread().getName() );//Thread-1
		}
	}
}
