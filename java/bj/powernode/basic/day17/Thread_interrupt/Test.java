package bj.powernode.basic.day17.Thread_interrupt;

public class Test {

	// 主线程
	public static void main( String[] args ) throws Exception {

		// 创建和启动新线程.
		Thread t1 = new Thread( new MyRunnable() );

		// 启动线程
		t1.start();

		Thread.sleep( 3000 );

		t1.interrupt();  // 中断线程.

	}

}
