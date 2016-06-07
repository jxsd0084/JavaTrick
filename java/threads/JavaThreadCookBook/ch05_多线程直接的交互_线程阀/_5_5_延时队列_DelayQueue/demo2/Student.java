package threads.JavaThreadCookBook.ch05_多线程直接的交互_线程阀._5_5_延时队列_DelayQueue.demo2;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 5.5 延时队列 DelayQueue
 */
public class Student implements Delayed {       // 必须实现Delayed接口

	private String name;
	private long   submitTime;                  // 交卷时间
	private long   workTime;                    // 考试时间

	public String getName() {

		return this.name + " 交卷,用时" + workTime;
	}

	public Student( String name, long submitTime ) {

		this.name = name;
		this.workTime = submitTime;
		this.submitTime = TimeUnit.NANOSECONDS.convert( submitTime, TimeUnit.MILLISECONDS ) + System.nanoTime();
		System.out.println( this.name + " 交卷,用时" + workTime );
	}

	// 必须实现getDelay方法
	public long getDelay( TimeUnit unit ) {

		// 返回一个延迟时间
		return unit.convert( submitTime - System.nanoTime(), unit.NANOSECONDS );
	}

	// 必须实现compareTo方法
	public int compareTo( Student o ) {

		// 比较的方法
		Student that = (Student) o;
		return submitTime > that.submitTime ? 1 : ( submitTime < that.submitTime ? -1 : 0 );
	}

	@Override
	public int compareTo( Delayed o ) {

		return 0;
	}

}