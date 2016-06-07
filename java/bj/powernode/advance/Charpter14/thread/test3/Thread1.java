package bj.powernode.advance.Charpter14.thread.test3;

public class Thread1 extends Thread {

	public void run() {

		for (; ; ) {
			System.out.println( "================" );
			try {

				// 在指定的毫秒数加指定的纳秒数内让当前正在执行的线程休眠（暂停执行）
				Thread.sleep( 50 );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
}
