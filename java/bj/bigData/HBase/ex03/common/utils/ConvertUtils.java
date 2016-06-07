package bj.bigData.HBase.ex03.common.utils;
/**
 * 数据类型转换工具类
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConvertUtils {
	
	public static int stringToInt( String s ) {

		try {
			return Integer.parseInt( s );
		} catch ( Exception e ) {
			return 0;
		}
	}

	public static long stringToLong( String s ) {

		try {
			return Long.parseLong( s );
		} catch ( Exception e ) {
			return 0;
		}
	}

	public static short stringToShort( String s ) {

		try {
			return Short.parseShort( s );
		} catch ( Exception e ) {
			return 0;
		}
	}

	public static double stringToDouble( String s ) {

		try {
			return Double.parseDouble( s );
		} catch ( Exception e ) {
			return 0;
		}
	}

	public static String longToDateString( long d ) {

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Calendar         can = Calendar.getInstance();
		can.setTimeInMillis( d );
		return sdf.format( can.getTime() );
	}

	/**
	 * 将String类型的日期转换为Date类型的日期
	 *
	 * @param date String类型的日期
	 * @return Date类型的日期
	 * @throws ParseException
	 */
	public static Date convertStringToDate( String date ) throws ParseException {

		Date       value      = null;
		DateFormat dateFormat = null;

//		if (date.length() < 20) {
//			date = date + ".000";
//		}

//		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		dateFormat = new SimpleDateFormat( "yyyyMMddHHmmss" );
		if ( date != null ) {
			value = dateFormat.parse( date );
		}

		dateFormat = null;
		return value;
	}

	public static String convertDateToYMDString( Date date ) {

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
		return sdf.format( date );
	}

	public static String longToYMDString( long d ) {

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
		Calendar         can = Calendar.getInstance();
		can.setTimeInMillis( d );
		return sdf.format( can.getTime() );
	}

	public static String convertDateToFullString( Date date ) {

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
		return sdf.format( date );
	}

	/**
	 * 转换yyyyMMddHHmmss格式的时间为yyyy-MM-dd HH:mm:ss
	 *
	 * @param in
	 * @return
	 */
	public static String lineDateToSimpleDate( String in ) {

		SimpleDateFormat informat  = new SimpleDateFormat( "yyyyMMddHHmmss" );
		SimpleDateFormat outformat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		String           out       = "";
		try {
			out = outformat.format( informat.parse( in ) );
		} catch ( ParseException e ) {
		}
		return out;
	}
}
