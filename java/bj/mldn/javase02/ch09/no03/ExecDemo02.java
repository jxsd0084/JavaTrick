package bj.mldn.javase02.ch09.no03;

class MyThread2 implements Runnable {

	private String name;
	private int    time;

	public MyThread2( String name, int time ) {

		this.name = name;    // 设置线程名称
		this.time = time;    // 设置休眠时间
	}

	public void run() {

		try {
			Thread.sleep( this.time );    // 休眠指定的时间
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( this.name + "线程，休眠" +
		                    this.time + "毫秒。" );
	}
}

public class ExecDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread2 mt1 = new MyThread2( "线程A", 10000 );    // 定义线程对象，指定休眠时间
		MyThread2 mt2 = new MyThread2( "线程B", 20000 );    // 定义线程对象，指定休眠时间
		MyThread2 mt3 = new MyThread2( "线程C", 30000 );    // 定义线程对象，指定休眠时间
		new Thread( mt1 ).start();                         // 启动线程
		new Thread( mt2 ).start();                         // 启动线程
		new Thread( mt3 ).start();                         // 启动线程
	}
}
