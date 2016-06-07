package bj.mldn.javase01.no42.syndemo;

class MyTicketThread3 implements Runnable {// 实现Runnable接口
	private int ticket = 5; // 一共才5张票

	public void run() {// 覆写run()方法

		for ( int i = 0; i < 50; i++ ) {// 表示循环10次

			this.sale(); // 调用同步方法
		}
	}

	public synchronized void sale() {// 增加同步方法

		if ( this.ticket > 0 ) {
			try {
				Thread.sleep( 300 );// 延迟

			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}

			System.out.println( "卖票：ticket = " + this.ticket-- );
		}
	}
}

public class SynDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyTicketThread3 mt = new MyTicketThread3(); // 一个线程

		new Thread( mt, "票贩子-A " ).start(); // 开始卖票
		new Thread( mt, "票贩子-B " ).start(); // 开始卖票
		new Thread( mt, "票贩子-C " ).start(); // 开始卖票

	}

}
