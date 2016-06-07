package bj.mldn.javase01.no42.namedemo;

public class ThreadNameDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyThread mt      = new MyThread(); // Runnable子类实例

		Thread   thread1 = new Thread( mt, "线程A" );
		Thread   thread2 = new Thread( mt, "线程B" );
		Thread   thread3 = new Thread( mt, "线程C" );

		thread1.start();
		thread2.start();
		thread3.start();

	}

}
