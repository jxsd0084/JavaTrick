package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_3_链表阻塞队列_LinkedBlockingQueue.ex01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2016/6/5.
 */
// 消费者
public class Consumer implements Runnable {
	
	private BlockingQueue< String > queue;
	private String                  consumer;

	public Consumer( BlockingQueue< String > queue, String consumer ) {

		this.queue = queue;
		if ( null != consumer ) {
			this.consumer = consumer;
		} else {
			this.consumer = "null ";
		}
	}

	@Override
	public void run() {

		try {
			String uuid = queue.take();
			System.out.println( consumer + " decayed " + uuid
			                    + " " + Thread.currentThread() );
		} catch ( InterruptedException e ) {
			System.out.println( e.getMessage() );
		}
	}

}
