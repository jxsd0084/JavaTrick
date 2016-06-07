package bj.powernode.advance.Charpter14.thread.test1;

// 创建新执行线程x有两种方法。一种方法是将类声明为 Thread 的子类。
public class MyThread1 extends Thread {

	// 构造方法.
	public MyThread1( String name ) {

		// 继承自父类Thread,显性添加super关键字
		super( name );
	}

	// 该子类应重写 Thread 类的 run 方法。
	public void run() {

		// for循环从0到100000000
		for ( int i = 0; i < 100000000; i++ ) {

			// 输出线程名和循环次数
			System.err.println( this.getName() + "=======================i" + i );

			// 中断线程的方法,设置某个标志位或条件,来中断线程的执行
			// 而不要调用stop()方法
			// 当循环次数等于100时,用break强制结束循环
			if ( i == 100 ) {
				break;
			}
		}
	}
}
