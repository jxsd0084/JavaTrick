package bj.mldn.javase02.ch11.no16;// 完成具体的任务操作

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

class MyTask extends TimerTask {    // 任务调度类都要继承TimerTask

	public void run() {

		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
		System.out.println( "当前系统时间为：" + sdf.format( new Date() ) );
	}
}
