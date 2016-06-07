package bj.powernode.basic.day18;

/*

	死锁.

*/
public class DeadLock {

	static Object o1 = new Object(), o2 = new Object();

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {


		Thread t1 = new Thread( new Runnable() {

			public void run() {

				synchronized ( o1 ) {
					try {
						Thread.sleep( 1000 );
					} catch ( Exception e ) {
						e.printStackTrace();
					}
					synchronized ( o2 ) {
						System.out.println( "t1 run.." );
					}
				}
			}
		} );

		Thread t2 = new Thread( new Runnable() {

			public void run() {

				synchronized ( o2 ) {
					synchronized ( o1 ) {
						System.out.println( "t2 run." );
					}
				}
			}

		} );

		t1.start();

		t2.start();

	}

}
