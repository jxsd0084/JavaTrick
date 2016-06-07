package threads.JavaThreadDesign.ch5;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	public static Object             u  = new Object();
	static        ChangeObjectThread t1 = new ChangeObjectThread( "t1" );
	static        ChangeObjectThread t2 = new ChangeObjectThread( "t2" );

	public static class ChangeObjectThread extends Thread {

		public ChangeObjectThread( String name ) {

			super.setName( name );
		}

		@Override
		public void run() {

			synchronized ( u ) {

				System.out.println( "in " + getName() );

				LockSupport.park();
			}
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		t1.start();

		Thread.sleep( 100 );

		t2.start();

		LockSupport.unpark( t1 );
		LockSupport.unpark( t2 );

		t1.join();
		t2.join();

	}

}

/*

Java中Lock和LockSupport的区别到底是什么？

URL:    http://www.zhihu.com/question/26471972/answer/74773092

Java中用Lock代替了synchronized关键字来更好的实现线程同步，但最近又发现了LockSupport，

其作用和Lock极为相似，那么这两者到底又有什么区别？

有了Lock为什么还有LockSupport又或者说LockSupport是先于Lock出现的？？

*/
