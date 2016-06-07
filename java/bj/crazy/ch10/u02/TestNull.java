package bj.crazy.ch10.u02;

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
public class TestNull {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Date d = null;

		try {

			System.out.println( d.after( new Date() ) );

		} catch ( NullPointerException ne ) {

			System.out.println( "空指针异常" );
		} catch ( Exception e ) {

			System.out.println( "未知异常" );
		}

	}

}
