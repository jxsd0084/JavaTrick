package bj.Java1200.col01.ch04_字符串处理技术.ch04_1_格式化字符串._061_格式化当前日期;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {

	public static void main( String[] args ) {

		Date date = new Date();
		DateFormat formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                                  Locale.CHINA );
		// 中国日期
		String string = formater.format( date );
		System.out.println( "中国日期：\t" + string );
		// 加拿大日期
		formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                       Locale.CANADA );
		System.out.println( "加拿大日期：\t" + formater.format( date ) );
		// 日本日期
		formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                       Locale.JAPAN );
		System.out.println( "日本日期：\t" + formater.format( date ) );
		// 法国日期
		formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                       Locale.FRANCE );
		System.out.println( "法国日期：\t" + formater.format( date ) );
		// 德国日期
		formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                       Locale.GERMAN );
		System.out.println( "德国日期：\t" + formater.format( date ) );
		// 意大利日期
		formater = DateFormat.getDateInstance( DateFormat.FULL,
		                                       Locale.ITALIAN );
		System.out.println( "意大利日期：\t" + formater.format( date ) );
	}

}
