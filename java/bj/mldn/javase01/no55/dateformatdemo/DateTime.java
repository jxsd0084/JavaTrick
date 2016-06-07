package bj.mldn.javase01.no55.dateformatdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	private SimpleDateFormat sdf = null;

	public String getDate() {               // 2009-03-02

		this.sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		String str = this.sdf.format( new Date() );
		return str;
	}

	public String getDateTime() {           // 2009-03-02 16:19:34.123
		this.sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss.SSS" );
		String str = this.sdf.format( new Date() );
		return str;
	}

	public String getDateComplete() {       // 2009年03月02日

		this.sdf = new SimpleDateFormat( "yyyy年MM月dd日" );
		String str = this.sdf.format( new Date() );
		return str;
	}

	public String getDateTimeComplete() {   // 2009年03月02日16时19分34秒123毫秒

		this.sdf = new SimpleDateFormat( "yyyy年MM月dd日 hh时mm分ss秒SSS毫秒" );
		String str = this.sdf.format( new Date() );
		return str;
	}

	public String getDateTimeStamp() {

		this.sdf = new SimpleDateFormat( "yyyyMMddhhmmssSSS" );
		String str = this.sdf.format( new Date() );
		return str;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		DateTime dt = new DateTime();

		System.out.println( dt.getDateTimeComplete() );
		System.out.println( dt.getDateTime() );
		System.out.println( dt.getDateTimeStamp() );

	}

}
