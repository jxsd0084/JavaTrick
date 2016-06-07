package bj.mldn.javase02.ch09.no06;

class MyThread implements Runnable {

	private boolean flag = true;                 // 定义标志位

	public void run() {

		int i = 0;
		while ( this.flag ) {
			System.out.println( Thread.currentThread().getName()
			                    + "运行，i = " + ( i++ ) );
		}
	}

	public void stop() {

		this.flag = false;                       // 修改标志位
	}
}

public class StopDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread my = new MyThread();
		Thread   t  = new Thread( my, "线程" );    // 建立线程对象
		t.start();                                // 启动线程
		try {
			Thread.sleep( 30 );
		} catch ( Exception e ) {

		}
		my.stop();                                // 修改标志位，停止运行
	}
}
