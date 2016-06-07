package bj.powernode.basic.day13.date_handler;

import java.util.*;

// java.lang.String; ---> java.util.Date;
public class TestDate2 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 客户提交的日期
		String birthday = "1983-11-01"; // 0-11 表示 1-12月

		String[] times = birthday.split( "-" );

		String strYear  = times[ 0 ];
		String strMonth = times[ 1 ];
		String strDay   = times[ 2 ];

		int year  = Integer.parseInt( strYear );
		int month = Integer.parseInt( strMonth );
		int day   = Integer.parseInt( strDay );

		Calendar c = new GregorianCalendar( year, month - 1, day );


		// 转换.
		Date birth = c.getTime();

		System.out.println( birth.toString() );


	}

}
