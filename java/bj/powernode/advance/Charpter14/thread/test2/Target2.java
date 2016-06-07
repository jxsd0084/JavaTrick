package bj.powernode.advance.Charpter14.thread.test2;

//创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法。
public class Target2 implements Runnable {

	@Override
	public void run() {

		for ( int i = 1000; i > 0; i-- ) {

			// currentThread()返回对当前正在执行的线程对象的引用	getId()返回该线程的标识符
			System.err.println( "i=====================" + i + "        " + Thread.currentThread().getId() );
		}
	}
}
