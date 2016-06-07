package bj.crazy.ch16.u04;

import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestSleep {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		for ( int i = 0; i < 10; i++ ) {

			System.out.println( "当前时间: " + new Date() );

			// 调用sleep方法让当前线程暂停1s。
			Thread.sleep( 1000 );
		}

	}

}
