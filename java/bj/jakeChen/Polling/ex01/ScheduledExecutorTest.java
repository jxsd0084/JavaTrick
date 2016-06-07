package bj.jakeChen.Polling.ex01;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenlong on 2016/5/26.
 */

/*

ScheduledExecutorTest

鉴于 Timer 的上述缺陷，Java 5 推出了基于线程池设计的 ScheduledExecutorTest。

其设计思想是，每一个被调度的任务都会由线程池中一个线程去执行，因此任务是并发执行的，相互之间不会受到干扰。

需要注意的是，只有当任务的执行时间到来时，ScheduedExecutor 才会真正启动一个线程，

其余时间 ScheduledExecutorTest 都是在轮询任务的状态。

*/
public class ScheduledExecutorTest implements Runnable {

	private String jobName = "";

	public ScheduledExecutorTest( String jobName ) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println( "execute " + jobName );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool( 10 );

		long initialDelay1 = 1;
		long period1       = 1;

		// 从现在开始 1秒钟 之后，每隔 1秒钟 执行一次 job1
		service.scheduleAtFixedRate( new ScheduledExecutorTest( "job1" ), initialDelay1, period1, TimeUnit.SECONDS );

		long initialDelay2 = 1;
		long delay2        = 1;

		// 从现在开始 2秒钟 之后，每隔 2秒钟 执行一次 job2
		service.scheduleAtFixedRate( new ScheduledExecutorTest( "job2" ), initialDelay2, delay2, TimeUnit.SECONDS );

	}

}

/*

URL:    http://www.cnblogs.com/shenliang123/p/3231312.html



上面代码展示了 ScheduledExecutorService 中两种最常用的调度方法 ScheduleAtFixedRate 和 ScheduleWithFixedDelay。

ScheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔，即每次执行时间为 :initialDelay, initialDelay+period, initialDelay+2*period, …；

ScheduleWithFixedDelay 每次执行时间为上一次任务结束起向后推一个时间间隔，即每次执行时间为：initialDelay, initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delay。

由此可见，ScheduleAtFixedRate 是基于固定时间间隔进行任务调度，ScheduleWithFixedDelay 取决于每次任务执行的时间长短，是基于不固定时间间隔进行任务调度。

*/
