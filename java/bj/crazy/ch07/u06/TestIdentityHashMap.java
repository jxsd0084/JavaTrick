package bj.crazy.ch07.u06;

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
public class TestIdentityHashMap {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		IdentityHashMap ihm = new IdentityHashMap();

		// 下面两行代码将会向IdentityHashMap对象中添加2个key-value对
		ihm.put( new String( "语文" ), 89 );
		ihm.put( new String( "语文" ), 78 );

		ihm.put( "java", 93 );
		ihm.put( "java", 98 );

		System.out.println( ihm );

	}

}
