package bj.mldn.javase01.no55.dateformatdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		String           str  = "2009-03-03 09:21:35.345";

		SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss.SSS" );
		SimpleDateFormat sdf2 = new SimpleDateFormat( "yyyy年MM月dd日 hh时mm分ss秒SSS毫秒" );

		Date   date   = sdf1.parse( str );    // 提取格式中的日期

		String newStr = sdf2.format( date );  // 改变格式

		System.out.println( "转换之后的日期：" + newStr );

	}

}
