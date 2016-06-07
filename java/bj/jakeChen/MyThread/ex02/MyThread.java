package bj.jakeChen.MyThread.ex02;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread extends Thread {
	
	@Override
	public void run() {

		int i = 5;
		for ( int j = 0; j < i; j++ ) {

			System.out.println( Thread.currentThread().getName() + " -> " + j );
		}
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		MyThread thread3 = new MyThread();

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
