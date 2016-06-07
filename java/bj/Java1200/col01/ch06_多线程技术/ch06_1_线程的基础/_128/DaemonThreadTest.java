package bj.Java1200.col01.ch06_多线程技术.ch06_1_线程的基础._128;

/**
 * 使用守护线程
*/
public class DaemonThreadTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Thread userThread   = new Thread( new Worker() ); // 创建用户线程
		Thread daemonThread = new Thread( new Timer() ); // 创建守护线程

		daemonThread.setDaemon( true ); // 设置守护线程

		userThread.start(); // 启动用户线程
		daemonThread.start(); // 启动守护线程

	}

}
