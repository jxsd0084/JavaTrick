package bj.powernode.basic.day13.date_handler;

import java.text.SimpleDateFormat;
import java.util.Date;



/*

	日期的处理需要用到的API：
		java.util.Date; 日期类
		java.util.Calendar; 日历类(抽象类)
			java.util.GregorianCalendar; 格里高利的日历类.


		日期格式化类: java.text.SimpleDateFormat;

		java.util.Date; ----> java.lang.String;

*/
public class TestDate {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {


		// 0.如何获取从1970 1 1 00:00:00:00 到目前的毫秒数.
		long totalMills = System.currentTimeMillis();
		System.out.println( totalMills );




		// 1.如何在java语言中获取系统当前的时间.
		Date nowTime = new Date();
		System.out.println( nowTime );


		// 2.将java.util.Date ---> java.lang.String;
		// 期望格式: 2010-10-01
		SimpleDateFormat sdf        = new SimpleDateFormat( "yyyy-MM-dd" );  // 格式化对象.
		String           nowTimeStr = sdf.format( nowTime );
		System.out.println( nowTimeStr );


		SimpleDateFormat sdf2        = new SimpleDateFormat( "yyyy年MM月dd日 HH时mm分ss秒" );  // 格式化对象.
		String           nowTimeStr2 = sdf2.format( nowTime );
		System.out.println( nowTimeStr2 );

	}

}
