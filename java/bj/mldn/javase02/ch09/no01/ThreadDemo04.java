package bj.mldn.javase02.ch09.no01;

class MyThread6 extends Thread {    // 继承Thread类，作为线程的实现类

	private int ticket = 5;         // 表示一共有5张票

	public void run() {             // 覆写run()方法，作为线程 的操作主体
		for ( int i = 0; i < 100; i++ ) {
			if ( this.ticket > 0 ) {
				System.out.println( "卖票：ticket = " + ticket-- );
			}
		}
	}
}

public class ThreadDemo04 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		MyThread6 mt1 = new MyThread6();     // 实例化对象
		MyThread6 mt2 = new MyThread6();     // 实例化对象
		MyThread6 mt3 = new MyThread6();     // 实例化对象
		mt1.run();                           // 调用线程主体
		mt2.run();                           // 调用线程主体
		mt3.run();                           // 调用线程主体
	}
}
