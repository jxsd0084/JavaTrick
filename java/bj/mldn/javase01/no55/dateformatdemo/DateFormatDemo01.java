package bj.mldn.javase01.no55.dateformatdemo;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Date       date           = new Date();

		DateFormat formatDate     = DateFormat.getDateInstance();
		DateFormat formatDatetime = DateFormat.getDateTimeInstance();

		System.out.println( formatDate.format( date ) );     // 格式化日期
		System.out.println( formatDatetime.format( date ) ); // 格式化日期

	}

}
