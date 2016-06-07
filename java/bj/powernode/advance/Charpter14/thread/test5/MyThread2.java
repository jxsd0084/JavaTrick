package bj.powernode.advance.Charpter14.thread.test5;

public class MyThread2 extends Thread {

	public MyThread2( String name ) {

		super( name );
	}

	// 线程体,主要是线程要执行的操作
	public void run() {

		for ( int i = 100000; i > 0; i-- ) {
			System.out.println( "i=" + i + "=======================" + this.getName() );
		}
	}
}
