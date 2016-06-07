package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_8_链表传输队列_LinkedTransferQueue.demo4;

import java.util.concurrent.TransferQueue;

/**
 * 5.8 链表传输队列 LinkedTransferQueue
 */
public class Consumer implements Runnable {

	private final TransferQueue< String > queue;

	public Consumer( TransferQueue< String > queue ) {

		this.queue = queue;
	}

	@Override
	public void run() {

		try {

			System.out.println( " Consumer " + Thread.currentThread().getName() + queue.take() );

		} catch ( InterruptedException e ) {
		}

	}

}