package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_3_链表阻塞队列_LinkedBlockingQueue.ex01;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2016/6/5.
 */
// 生产者实现
public class Producer implements Runnable {

	private BlockingQueue< String > queue;
	private String                  produce;

	public Producer( BlockingQueue< String > queue, String produce ) {

		this.queue = queue;
		if ( null != produce ) {
			this.produce = produce;
		} else {
			this.produce = "null ";
		}
	}

	@Override
	public void run() {

		String uuid = UUID.randomUUID().toString();
		try {
			Thread.sleep( 200 ); // 生产需要时间
			queue.put( produce + " : " + uuid );
			System.out.println( "Produce \"" + produce + "\" : " + uuid + " " + Thread.currentThread() );

		} catch ( InterruptedException e ) {
			System.out.println( e.getMessage() );
		}
	}

}
