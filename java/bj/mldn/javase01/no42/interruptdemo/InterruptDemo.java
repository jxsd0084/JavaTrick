package bj.mldn.javase01.no42.interruptdemo;

class MyThread implements Runnable {

	public void run() {

		System.out.println( "1、进入run()方法体" );

		try {

			System.out.println( "2、线程休眠20秒钟" );

			Thread.sleep( 20000 ); // 每个休眠20秒

			System.out.println( "3、线程正常休眠20秒钟" );

		} catch ( InterruptedException e ) {

			System.out.println( "4、线程休眠被中断" );
			return;// 返回方法调用处
		}
		System.out.println( "5、正常结束run()方法体" );
	}

}

public class InterruptDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyThread mt     = new MyThread();
		Thread   thread = new Thread( mt, "线程A" );

		thread.start();// 启动线程

		try {

			Thread.sleep( 2000 ); // 保证程序至少执行2秒

		} catch ( InterruptedException e ) {

			e.printStackTrace();
		}

		thread.interrupt(); // 中断
	}

}
