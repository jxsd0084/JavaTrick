package bj.powernode.advance.Charpter14.thread.test6;

//创建类继承Thread
public class MyThread1 extends Thread {

	// 有参构造参数(String name)
	public MyThread1( String name ) {
		// 调用父类的有参构造
		super( name );
	}

	// 重写父类Thread的run方法
	public void run() {
		// for循环0到1000
		for ( int i = 0; i <= 1000; i++ ) {
			// 输出当前线程名称和循环得到的i值
			System.out.println( this.getName() + "在计数========================i="
			                    + i );
		}
	}

}
