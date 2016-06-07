package threads.JavaThreadCookBook.ch07_JDK7新增的Fork_Join._1_认识Future任务机制和FutureTask;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2016/6/5.
 */
public class FutureTaskDemo {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		SonTask              task1 = new SonTask( "Thread Son1" );
		FutureTask< String > f1    = new FutureTask< String >( task1 );
		new Thread( f1 ).start();
		try {
			System.out.println( f1.get() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		FutureTask f2 = new FutureTask< Integer >( new MyRun(), 22 );
		new Thread( f2 ).start();
		try {
			System.out.println( "result_" + f2.get() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		System.out.println( "Thread Main End !" );
	}
	
}

class SonTask implements Callable< String > {

	private String name = "";

	public SonTask( String name ) {

		this.name = name;
	}

	@Override
	public String call() throws Exception {

		Thread.sleep( 1000L );
		System.out.println( name + "任务计算完成" );
		return "result_11";
	}

}


class MyRun implements Runnable {

	@Override
	public void run() {

		try {

			Thread.sleep( 1000L );
		} catch ( Exception e ) {
			e.printStackTrace();

		}
		System.out.println( "特定线程2完成" );
	}
}