package threads.JavaThreadDesign.ch5;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int           i    = 0;

	@Override
	public void run() {

		for ( int j = 0; j < 10000000; j++ ) {

			lock.lock();

			try {

				i++;

			} finally {
				lock.unlock();

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

		ReenterLock tl = new ReenterLock();

		Thread t1 = new Thread( tl );
		Thread t2 = new Thread( tl );

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println( i );

	}

}

/*

Java中的ReentrantLock和synchronized两种锁定机制的对比

URL:    http://blog.csdn.net/fw0124/article/details/6672522


什么时候选择用 ReentrantLock 代替 synchronized

既然如此，我们什么时候才应该使用 ReentrantLock 呢？

答案非常简单 —— 在确实需要一些 synchronized 所没有的特性的时候，

比如时间锁等候、可中断锁等候、无块结构锁、多个条件变量或者锁投票。

ReentrantLock 还具有可伸缩性的好处，应当在高度争用的情况下使用它，

但是请记住，大多数 synchronized 块几乎从来没有出现过争用，所以可以把高度争用放在一边。

我建议用 synchronized 开发，直到确实证明 synchronized 不合适，而不要仅仅是假设如果使用 ReentrantLock “性能会更好”。

请记住，这些是供高级用户使用的高级工具。

（而且，真正的高级用户喜欢选择能够找到的最简单工具，直到他们认为简单的工具不适用为止。）。

一如既往，首先要把事情做好，然后再考虑是不是有必要做得更快。


*/

