package bj.crazy.ch18.u06;

import javax.swing.*;
import java.util.Date;

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
public class YeekuObjectFactory2 {

	public static < T > T getInstance( Class< T > cls ) {

		try {

			return cls.newInstance();
		} catch ( Exception e ) {

			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 获取实例后无需类型转换

		Date   d = YeekuObjectFactory2.getInstance( Date.class );

		System.out.println("Date -> " + d);






		JFrame f = YeekuObjectFactory2.getInstance( JFrame.class );

		System.out.println("JFrame -> " + f);



	}

}
