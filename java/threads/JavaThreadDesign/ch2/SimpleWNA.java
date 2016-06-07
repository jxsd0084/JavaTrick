package threads.JavaThreadDesign.ch2;

public class SimpleWNA {

	final static Object object = new Object();

	public static class T1 extends Thread {

		public void run() {

			synchronized ( object ) {

				System.out.println( "T1 start! wait on object" );

				try {

					object.wait();

					Thread.sleep( 1000 );

				} catch ( InterruptedException e ) {

					e.printStackTrace();
				}

				System.out.println( "T1 end!" );
			}
		}
	}

	public static class T2 extends Thread {

		public void run() {

			synchronized ( object ) {

				System.out.println( "T2 start! notify all threads" );

				object.notifyAll();

				System.out.println( "T2 end!" );

				try {

					Thread.sleep( 2000 );

				} catch ( InterruptedException e ) {

				}
			}
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		Thread t1   = new T1();
		Thread t1_1 = new T1();

		t1_1.start();
		t1.start();

		System.out.println( "t1 == t1_1 -> " + ( t1 == t1_1 ) );

		Thread.sleep( 1000 );

		Thread t2 = new T2();

		t2.start();

	}

}
