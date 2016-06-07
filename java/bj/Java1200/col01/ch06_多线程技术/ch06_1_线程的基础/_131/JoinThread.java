package bj.Java1200.col01.ch06_多线程技术.ch06_1_线程的基础._131;

/**
 * 线程插队运行
 */
public class JoinThread {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Thread thread = new Thread( new EmergencyThread() );
		thread.start();
		for ( int i = 1; i < 6; i++ ) {
			try {
				Thread.sleep( 100 );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
			System.out.println( "正常情况：" + i + "号车出发！" );
			try {
				thread.join();
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
}
