package bj.powernode.basic.day18.review_day17;

public class MyRunnable implements Runnable {

	public void run() {

		System.out.println( "MyRunnable run execute." );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		MyRunnable r = new MyRunnable();
		Thread     t = new Thread( r );
		t.start();

	}

}
