package bj.mldn.javase01.no42.sleepdemo;

public class ThreadSleepDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread mt = new MyThread();

		new Thread( mt, "线程A" ).start();
		new Thread( mt, "线程B" ).start();

	}

}
