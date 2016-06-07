package bj.powernode.basic.day17.Thread_interrupt;

public class MyRunnable implements Runnable {

	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );

			} catch ( Exception e ) {

				return;
			}

			System.out.println( i );
		}
	}

}
