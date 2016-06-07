package bj.mldn.javase01.no55.datedemo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTime {

	private Calendar calendar = new GregorianCalendar(); // 实例化Calendar对象

	public String getDate() {// 2009-03-02
		StringBuffer buf = new StringBuffer();
		buf.append( calendar.get( Calendar.YEAR ) ).append( "-" );
		buf.append( this.addZero( ( calendar.get( Calendar.MONTH ) + 1 ), 2 ) ).append(
				"-" );
		buf.append( this.addZero( calendar.get( Calendar.DAY_OF_MONTH ), 2 ) );
		return buf.toString();
	}

	public String getDateTime() {// 2009-03-02 16:19:34.123
		StringBuffer buf = new StringBuffer();
		buf.append( this.getDate() ).append( " " );
		buf.append( this.addZero( calendar.get( Calendar.HOUR_OF_DAY ), 2 ) ).append(
				":" );
		buf.append( this.addZero( calendar.get( Calendar.MINUTE ), 2 ) ).append( ":" );
		buf.append( this.addZero( calendar.get( Calendar.SECOND ), 2 ) ).append( "" );
		buf.append( this.addZero( calendar.get( Calendar.MILLISECOND ), 3 ) );
		return buf.toString();
	}

	public String getDateComplete() {// 2009年03月02日
		StringBuffer buf = new StringBuffer();
		buf.append( calendar.get( Calendar.YEAR ) ).append( "年" );
		buf.append( this.addZero( ( calendar.get( Calendar.MONTH ) + 1 ), 2 ) ).append(
				"月" );
		buf.append( this.addZero( calendar.get( Calendar.DAY_OF_MONTH ), 2 ) )
		   .append( "日" );
		return buf.toString();
	}

	public String getDateTimeComplete() {// 2009年03月02日16时19分34秒123毫秒
		StringBuffer buf = new StringBuffer();
		buf.append( this.getDateComplete() );
		buf.append( this.addZero( calendar.get( Calendar.HOUR_OF_DAY ), 2 ) ).append(
				"时" );
		buf.append( this.addZero( calendar.get( Calendar.MINUTE ), 2 ) ).append( "分" );
		buf.append( this.addZero( calendar.get( Calendar.SECOND ), 2 ) ).append( "秒" );
		buf.append( this.addZero( calendar.get( Calendar.MILLISECOND ), 3 ) ).append(
				"毫秒" );
		return buf.toString();
	}

	private String addZero( int temp, int len ) {

		StringBuffer str = new StringBuffer();
		str.append( temp );     // 加入数字
		while ( str.length() < len ) {

			str.insert( 0, 0 ); // 在第一个位置加上字母0
		}
		return str.toString();
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( new DateTime().getDateTimeComplete() );
	}

}
