package bj.powernode.advance.Charpter14.thread.test3;

public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Thread1 t1 = new Thread1();

		// 当JVM发现只有一个守护线程在运行的时候,JVM会关闭

		// 相对于守护线程的线程,叫做用户线程
		// 用户线程如果没有结束,JVM无法关闭

		// setDaemon(boolean on) 将该线程标记为守护线程或用户线程	
		t1.setDaemon( true );
		t1.start();

	}

}
