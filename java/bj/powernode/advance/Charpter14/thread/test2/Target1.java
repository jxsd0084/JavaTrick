package bj.powernode.advance.Charpter14.thread.test2;

/**
 * 称为目标对象,专门让线程来执行的
 *
 * @author Administrator
 */
// 创建线程的另一种方法是声明实现 Runnable 接口的类。该类然后实现 run 方法。
public class Target1 implements Runnable {

	@Override
	public void run() {

		for ( int i = 0; i < 1000; i++ ) {

			//currentThread()返回对当前正在执行的线程对象的引用	getId()返回该线程的标识符
			System.out.println( "==================i=" + i + "       " + Thread.currentThread().getId() );
		}
	}

}
