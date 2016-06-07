package bj.jakeChen.MyThread.ex01;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyThread02 implements Runnable {
	
	@Override
	public void run() {

		int i = 5;
		for ( int j = 0; j < i; j++ ) {

			System.out.println( "-> " + j );
		}
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		MyThread02 thread = new MyThread02();

		thread.run();
	}

}
