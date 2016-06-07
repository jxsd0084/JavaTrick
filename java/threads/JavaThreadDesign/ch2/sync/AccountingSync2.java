package threads.JavaThreadDesign.ch2.sync;


public class AccountingSync2 implements Runnable {

	static AccountingSync2 instance = new AccountingSync2();
	static int             i        = 0;

	public synchronized void increase() {

		i++;
	}

	@Override
	public void run() {

		for ( int j = 0; j < 10000000; j++ ) {

			increase();
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		Thread t1 = new Thread( instance );
		Thread t2 = new Thread( instance );

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println( i );

	}

}
