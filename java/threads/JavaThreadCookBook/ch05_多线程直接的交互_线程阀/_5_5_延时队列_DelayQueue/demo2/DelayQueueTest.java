package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_5_延时队列_DelayQueue.demo2;

import java.util.concurrent.DelayQueue;

/**
 * 5.5 延时队列 DelayQueue
 */
public class DelayQueueTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		// 新建一个等待队列
		final DelayQueue< Student > bq = new DelayQueue< Student >();

		for ( int i = 0; i < 5; i++ ) {

			Student student = new Student( "学生" + i, Math.round( ( Math.random() * 10 + i ) ) );
			bq.put( student ); // 将数据存到队列里！
		}

		// 获取但不移除此队列的头部；如果此队列为空，则返回 null。
		System.out.println( bq.peek().getName() );

		// 获取并移除此队列的头部，在可从此队列获得到期延迟的元素，或者到达指定的等待时间之前一直等待（如有必要）。
		// poll(long timeout, TimeUnit unit) 大家可以试一试这个方法

	}

}