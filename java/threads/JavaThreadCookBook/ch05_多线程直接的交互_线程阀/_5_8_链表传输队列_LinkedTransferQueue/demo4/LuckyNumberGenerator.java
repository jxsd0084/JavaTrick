package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_8_链表传输队列_LinkedTransferQueue.demo4;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 5.8 链表传输队列 LinkedTransferQueue
 */
public class LuckyNumberGenerator {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		TransferQueue< String > queue    = new LinkedTransferQueue< String >();
		Thread                  producer = new Thread( new Producer( queue ) );

		producer.setDaemon( true ); // 设置为守护进程使得线程执行结束后程序自动结束运行

		producer.start();

		for ( int i = 0; i < 10; i++ ) {

			Thread consumer = new Thread( new Consumer( queue ) );
			consumer.setDaemon( true );
			consumer.start();

			try {
				// 消费者进程休眠一秒钟，以便以便生产者获得CPU，从而生产产品
				Thread.sleep( 1000 );

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			}

		}

	}

}