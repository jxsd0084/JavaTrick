package bj.powernode.basic.day17.线程死活;

public class MyRunnable implements Runnable {

	public void run() {

		Thread t = Thread.currentThread();

		System.out.println( "%%%%%%%%%%%" + t.getName() );  // Thread-0 Thread-1

	}

	// 主线程
	public static void main( String[] args ) {

		MyRunnable r = new MyRunnable();

		Thread t1 = new Thread( r );

		System.out.println( t1.isAlive() ? t1.getName() + "线程是活的" : t1.getName() + "线程是死的" );

		t1.start();

		System.out.println( t1.isAlive() ? t1.getName() + "线程是活的" : t1.getName() + "线程是死的" );


		// 测试线程的名字
		// 如果没有在程序中给线程起名字,线程默认系统名字: Thread-线程编号(0-N).
		Thread t2 = new Thread( r );
		// t2.setName("abcdef");
		System.out.println( "t2线程的名字=" + t2.getName() );

		t2.start();





		// 获取线程的ID
		long t1Id = t1.getId();
		long t2Id = t2.getId();

		System.out.println( t1.getName() + "线程的ID=" + t1Id );
		System.out.println( t2.getName() + "线程的ID=" + t2Id );





		// Thread.currentThread()出现在哪个线程中,就返回当前线程对象的引用.
		Thread mainT = Thread.currentThread();              // 主线程对象.

		// 如何获取主线程的名字
		String mainTName = mainT.getName();
		System.out.println( "主线程的名字=" + mainTName );    // main

		// 如何获取主线程的ID
		long mainTId = mainT.getId();
		System.out.println( "主线程的ID=" + mainTId );       // id=1


	}

}
