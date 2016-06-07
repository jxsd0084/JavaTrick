package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_3_链表阻塞队列_LinkedBlockingQueue.ex01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/6/5.
 */
public class Test {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 队列
		LinkedBlockingQueue< String > queue = new LinkedBlockingQueue< String >( 10 );

		ExecutorService service = Executors.newCachedThreadPool();
		for ( int i = 0; i < 6; i++ ) {

			service.submit( new Consumer( queue, "X二代" + i ) );
			service.submit( new Consumer( queue, "导演" + i ) );
		}

		for ( int i = 0; i < 6; i++ ) {

			service.submit( new Producer( queue, "黄金酒," + i ) );
			service.submit( new Producer( queue, "美女演员" + i ) );
		}
		service.shutdown();

	}

}

/*

URL:    http://www.linuxidc.com/Linux/2014-02/96335.htm


	LinkedBlockingQueue实现是线程安全的，实现了FIFO（先进先出）等特性.

是作为生产者消费者的首选，LinkedBlockingQueue 可以指定容量，也可以不指定，不指定的话，

默认最大是Integer.MAX_VALUE，其中主要用到put和take方法，put方法在队列满的时候会阻塞直到有队列成员被消费，

take方法在队列空的时候会阻塞，直到有队列成员被放进来。

书本上的话不再重复, 还是看看实例代码.

工厂生产制造  生产高大上洒, 还有美女.

消费者有X二代,也有导演.

让消费者抢资源吧.


 */
