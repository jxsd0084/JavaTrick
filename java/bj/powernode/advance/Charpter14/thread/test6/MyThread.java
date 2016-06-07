package bj.powernode.advance.Charpter14.thread.test6;

/**
 * 关键字: getName(); getPriority(); sleep();
 */
// 创建类继承Thread
public class MyThread extends Thread {

	// 构造方法参数(String name)
	public MyThread( String name ) {
		// 调用父类Thread的有参构造方法
		super( name );
	}

	// 重写父类的run方法
	public void run() {
		// for循环0到1000
		for ( int i = 0; i <= 1000; i++ ) {
			// 输出 getName() 返回该线程的名称 ;getPriority() 返回线程的优先级
			System.err.println( this.getName() + "在计数==============i=" + i
			                    + "   默认优先级:" + this.getPriority() );
			try {
				// 让线程睡上40毫秒
				Thread.sleep( 40 );
			} catch ( InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
