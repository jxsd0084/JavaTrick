package threads.JavaThreadDesign.ch4;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	static AtomicInteger i = new AtomicInteger();

	public static class AddThread implements Runnable {

		public void run() {

			for ( int k = 0; k < 10000; k++ ) {

				i.incrementAndGet();
			}
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException {

		Thread[] ts = new Thread[ 10 ];

		for ( int k = 0; k < 10; k++ ) {

			ts[ k ] = new Thread( new AddThread() );
		}

		for ( int k = 0; k < 10; k++ ) {

			ts[ k ].start();
		}

		for ( int k = 0; k < 10; k++ ) {

			ts[ k ].join();
		}

		System.out.println( i );

	}

}

/*

AtomicInteger

AtomicInteger，一个提供原子操作的Integer的类。
在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。
而AtomicInteger则通过一种线程安全的加减操作接口。

URL:    http://www.cnblogs.com/Gordon-YangYiBao/archive/2012/08/07/2626422.html


J2SE 5.0提供了一组atomic class来帮助我们简化同步处理。

基本工作原理是使用了同步synchronized的方法实现了对一个long, integer, 对象的增、减、赋值（更新）操作。

比如对于++运算符AtomicInteger可以将它持有的integer 能够atomic 地递增。

在需要访问两个或两个以上 atomic变量的程序代码（或者是对单一的atomic变量执行两个或两个以上的操作）通常都需要被synchronize以便两者的操作能够被当作是一个atomic的单元。

URL:    http://blog.csdn.net/zz198808/article/details/8029405

 */
