package bj.Java1200.col01.ch01_开发环境应用.ch06_1_线程的基础._131;

public class EmergencyThread implements Runnable {

	@Override
	public void run() {

		for ( int i = 1; i < 6; i++ ) {
			try {
				Thread.sleep( 100 );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
			System.out.println( "紧急情况：" + i + "号车出发！" );
		}
	}
}
