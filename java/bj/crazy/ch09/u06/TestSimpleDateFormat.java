package bj.crazy.ch09.u06;

import java.text.*;
import java.util.*;

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
public class TestSimpleDateFormat {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Date d = new Date();

		// 创建一个Simpledate
		SimpleDateFormat sdf1 = new SimpleDateFormat( "Gyyyy年中第D天" );

		// 将d格式化成日期，输出：公元2007年中第354天
		String dateStr = sdf1.format( d );

		System.out.println( dateStr );

		// 一个非常特殊的日期字符串
		String           str  = "07###三月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat( "y###MMM##d" );

		// 将日期字符串解析成日期，输出：Wed Mar 21 00:00:00 CST 2007
		System.out.println( sdf2.parse( str ) );

	}
}
