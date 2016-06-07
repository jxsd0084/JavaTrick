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
enum Season {
	SPRING, SUMMER, FALL, WINTER
}

public class TestEnumMap {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建一个EnumMap对象，该EnumMap的所有key必须是Season枚举类的枚举值
		EnumMap enumMap = new EnumMap( Season.class );

		enumMap.put( Season.SUMMER, "夏日炎炎" );
		enumMap.put( Season.SPRING, "春暖花开" );

		System.out.println( enumMap );

	}

} 
