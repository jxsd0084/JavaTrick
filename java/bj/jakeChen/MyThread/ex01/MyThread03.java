package bj.jakeChen.MyThread.ex01;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread03 implements Runnable {
	
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

		MyThread03 thread1  = new MyThread03();
		MyThread03 thread2 = new MyThread03();
		MyThread03 thread3 = new MyThread03();

		thread1.run();
		thread2.run();
		thread3.run();
	}

}
