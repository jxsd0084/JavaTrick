package bj.powernode.basic.day17.Thread_Sleep;

import java.util.Date;

public class Test {

	// 主线程
	public static void main( String[] args ) {

		MyRunnable r = new MyRunnable();

		Thread t1 = new Thread( r );

		t1.start();  // 启动线程 t1

		for ( int i = 0; i < 10; i++ ) {

			try {

				Thread.sleep( 1000 );
			} catch ( InterruptedException e ) {

				e.printStackTrace();
			}

			System.out.println( "****" + new Date() + "****" );
		}

	}

}
