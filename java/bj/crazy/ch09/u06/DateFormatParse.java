package bj.crazy.ch09.u06;

import java.text.*;

import static java.text.DateFormat.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DateFormatParse {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		String str1 = "2007-12-12";

		String str2 = "2007年12月10日";



		System.out.println( DateFormat.getDateInstance().parse( str1 ) );

		System.out.println( DateFormat.getDateInstance( LONG ).parse( str2 ) );

		System.out.println( DateFormat.getDateInstance().parse( str2 ) );


	}

}
