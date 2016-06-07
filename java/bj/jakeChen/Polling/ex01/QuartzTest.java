package bj.jakeChen.Polling.ex01;

import java.util.Date;

/**
 * Created by chenlong on 2016/5/26.
 */
public class QuartzTest implements Job {

	@Override
	// 该方法实现需要执行的任务
	public void execute( JobExecutionContext context ) throws JobExecutionException {
		System.out.println( "Generating report - " +
		                    context.getJobDetail().getFullName() + ", type =" +
		                    context.getJobDetail().getJobDataMap().get( "type" ) );
		System.out.println( new Date().toString() );
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		try {
			// 创建一个Scheduler
			SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
			Scheduler        sched     = schedFact.getScheduler();
			sched.start();

			// 创建一个JobDetail，指明name，groupname，以及具体的Job类名，
			// 该Job负责定义需要执行任务
			JobDetail jobDetail = new JobDetail( "myJob", "myJobGroup", QuartzTest.class );
			jobDetail.getJobDataMap().put( "type", "FULL" );

			// 创建一个每周触发的Trigger，指明星期几几点几分执行
			Trigger trigger = TriggerUtils.makeWeeklyTrigger( 3, 16, 38 );
			trigger.setGroup( "myTriggerGroup" );

			// 从当前时间的下一秒开始执行
			trigger.setStartTime( TriggerUtils.getEvenSecondDate( new Date() ) );

			// 指明trigger的name
			trigger.setName( "myTrigger" );

			// 用scheduler将JobDetail与Trigger关联在一起，开始调度任务
			sched.scheduleJob( jobDetail, trigger );

		} catch ( Exception e ) {
			e.printStackTrace();

		}
	}

}

/*

URL:    http://www.cnblogs.com/shenliang123/p/3231312.html



Caused by: java.lang.IllegalStateException: Detected both log4j-over-slf4j.jar AND slf4j-log4j12.jar on the class path, preempting StackOverflowError.

See also http://www.slf4j.org/codes.html#log4jDelegationLoop for more details.

*/
