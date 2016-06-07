package bj.powernode.basic.day17.Thread_priority;


/*

	线程的优先级:
		优先级: 1 -- 10
		默认的线程优先级是: 5
		
		优先级高的线程总是先抢到CPU的时间片.
	
*/
public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Thread t1 = new Thread01();

		t1.start();

		// 获取t1线程的优先级
		System.out.println( t1.getName() + "的优先级=" + t1.getPriority() );

		// 获取主线程的优先级
		System.out.println( Thread.currentThread().getName() + "的优先级=" + Thread.currentThread().getPriority() );


		// 设置优先级之前
		for ( int i = 0; i < 10; i++ ) {

			Thread.sleep( 500 );

			System.out.println( Thread.currentThread().getName() + "--->" + i );
		}


		// 改变主线程优先级.
		Thread.currentThread().setPriority( Thread.MAX_PRIORITY );  // 设置主线程优先级是10
		System.out.println( Thread.currentThread().getPriority() );


		// 设置优先级之后
		for ( int i = 10; i < 20; i++ ) {

			Thread.sleep( 500 );

			System.out.println( Thread.currentThread().getName() + "===>" + i );
		}

	}

}

class Thread01 extends Thread {

	// 20s
	public void run() {

		for ( int i = 0; i < 20; i++ ) {

			try {

				Thread.sleep( 500 );

				System.out.println( Thread.currentThread().getName() + "***>" + i );

			} catch ( Exception e ) {

			}

		}

	}

}


