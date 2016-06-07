package bj.mldn.javase02.ch11.no07;

import java.text.*;
import java.util.*;

class DateTime {                            // 以后直接通过此类就可以取得日期时间

	private SimpleDateFormat sdf = null;    // 声明SimpleDateFormat对象

	// 得到的是一个日期：格式为：yyyy-MM-dd HH:mm:ss.SSS
	public String getDate() {
		this.sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" );
		return this.sdf.format( new Date() );   // 将当前日期进行格式化操作
	}

	// 得到的是一个日期：格式为：yyyy年MM月dd日 HH时mm分ss秒SSS毫秒
	public String getDateComplete() {
		this.sdf = new SimpleDateFormat( "yyyy年MM月dd日HH时mm分ss秒SSS毫秒" );
		return this.sdf.format( new Date() );   // 将当前日期进行格式化操作
	}

	// 得到的是一个时间戳
	public String getTimeStamp() {
		this.sdf = new SimpleDateFormat( "yyyyMMddHHmmssSSS" );
		return this.sdf.format( new Date() );   // 将当前日期进行格式化操作
	}
}

public class DateDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		DateTime dt = new DateTime();



		System.out.println( "系统日期：" +
		                    dt.getDate() );



		System.out.println( "中文日期：" +
		                    dt.getDateComplete() );



		System.out.println( "时间戳：" +
		                    dt.getTimeStamp() );


	}
}
