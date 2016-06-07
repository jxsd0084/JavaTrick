package bj.jakeChen.MyThread.ex03;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread extends Thread {

	public MyThread( String name ) {

		super( name );
	}

	@Override
	public void run() {

		System.out.println( "MyThread - START " + Thread.currentThread().getName() );
		try {

			Thread.sleep( 1000 );

			// Get database Connection, delete unused data from DB
			doDBProcessing();
		} catch ( Exception e ) {
			e.printStackTrace();

		}
	}

	private void doDBProcessing() throws InterruptedException {

		Thread.sleep( 1000 );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		MyThread t1 = new MyThread( "t1" );
		MyThread t2 = new MyThread( "t2" );

		t1.start();
		t2.start();
	}

}

/*

URL:    http://www.importnew.com/9994.html

 */