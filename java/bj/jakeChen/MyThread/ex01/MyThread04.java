package bj.jakeChen.MyThread.ex01;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread04 implements Runnable {
	
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

/*
		// 之前错误的写法, 这种方式只能调用run()方法, 只有一个main线程在跑.
		MyThread04 thread1 = new MyThread04();
		MyThread04 thread2 = new MyThread04();
		MyThread04 thread3 = new MyThread04();
*/
		Thread thread1 = new Thread( new MyThread04() );
		Thread thread2 = new Thread( new MyThread04() );
		Thread thread3 = new Thread( new MyThread04() );

		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
