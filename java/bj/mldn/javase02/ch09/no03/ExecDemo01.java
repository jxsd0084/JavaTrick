package bj.mldn.javase02.ch09.no03;

class MyThread extends Thread {

	private int time;

	public MyThread( String name, int time ) {

		super( name );       // 设置线程名称
		this.time = time;    // 设置休眠时间
	}

	public void run() {

		try {
			Thread.sleep( this.time );    // 休眠指定的时间
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( Thread.currentThread().getName() + "线程，休眠"
		                    + this.time + "毫秒。" );
	}
}

public class ExecDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread mt1 = new MyThread( "线程A", 10000 );    // 定义线程对象，指定休眠时间
		MyThread mt2 = new MyThread( "线程B", 20000 );    // 定义线程对象，指定休眠时间
		MyThread mt3 = new MyThread( "线程C", 30000 );    // 定义线程对象，指定休眠时间
		mt1.start();                                     // 启动线程
		mt2.start();                                     // 启动线程
		mt3.start();                                     // 启动线程
	}
}
