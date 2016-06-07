package bj.crazy.ch07.u03;

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

public class TestTreeSetError2 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		TreeSet ts = new TreeSet();


		// 向TreeSet集合中添加两个Err对象
		ts.add( new String( "Struts权威指南" ) );
		ts.add( new Date() );

		/*

		java.lang.ClassCastException: java.lang.String cannot be cast to java.util.Date

		*/


	}
}
