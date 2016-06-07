package bj.powernode.basic.day17.Thread_Sleep;

import java.util.Date;

public class MyRunnable implements Runnable {

	// 重写方法不能抛出更宽泛的异常.
	public void run() {

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 ); // 阻塞1秒

			} catch ( InterruptedException e ) {

				e.printStackTrace();
			}

			System.out.println( "====" + new Date() + "====" );

		}

	}

}
