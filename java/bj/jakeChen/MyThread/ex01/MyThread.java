package bj.jakeChen.MyThread.ex01;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread implements Runnable {
	
	@Override
	public void run() {

		int i = 0;
		System.out.printf( "-> " + i++ );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		MyThread thread = new MyThread();

		thread.run();
	}

}
