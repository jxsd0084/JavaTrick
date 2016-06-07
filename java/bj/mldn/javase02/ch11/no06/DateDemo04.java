package bj.mldn.javase02.ch11.no06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		DateFormat df1 = null;        // 声明一个DateFormat
		DateFormat df2 = null;        // 声明一个DateFormat
		// 得到日期的DateFormat对象
		df1 = DateFormat.getDateInstance( DateFormat.YEAR_FIELD,
		                                  new Locale( "zh", "CN" ) );

		// 得到日期时间的DateFormat对象
		df2 = DateFormat.getDateTimeInstance( DateFormat.YEAR_FIELD,
		                                      DateFormat.ERA_FIELD, new Locale( "zh", "CN" ) );

		System.out.println( "DATE：" + df1.format( new Date() ) );       // 按照日期格式化
		System.out.println( "DATETIME：" + df2.format( new Date() ) );   // 按照日期时间格式化

	}
}
