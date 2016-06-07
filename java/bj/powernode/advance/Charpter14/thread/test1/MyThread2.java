package bj.powernode.advance.Charpter14.thread.test1;

// 创建新执行线程有两种方法。一种方法是将类声明为 Thread 的子类。
public class MyThread2 extends Thread {

	// 有参构造,参数:String name
	public MyThread2( String name ) {

		super( name );
	}

	// 该子类应重写 Thread 类的 run 方法。
	// 线程体,主要是线程要执行的操作
	public void run() {

		// for循环从100000开始递减
		for ( int i = 100000; i > 0; i-- ) {

			// 输出循环次数和线程名
			System.out.println( "i=" + i + "======================="
			                    + this.getName() );
		}
	}
}
