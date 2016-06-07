package bj.crazy.ch07.u08;

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
public class TestSearch {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		ArrayList nums = new ArrayList();

		nums.add( 2 );
		nums.add( - 5 );
		nums.add( 3 );
		nums.add( 0 );

		// 输出:[2, -5, 3, 0]
		System.out.println( nums );

		// 输出最大元素，将输出3
		System.out.println( Collections.max( nums ) );

		// 输出最小元素，将输出-5
		System.out.println( Collections.min( nums ) );

		// 将nums中的0使用1来代替
		Collections.replaceAll( nums, 0, 1 );

		// 输出:[2, -5, 3, 1]
		System.out.println( nums );

		// 判断-5 在List集合中出现的次数，返回1
		System.out.println( Collections.frequency( nums, - 5 ) );

		// 对nums集合排序
		Collections.sort( nums );

		// 输出:[-5, 1, 2, 3]
		System.out.println( nums );

		// 只有排序后的List集合才可用二分法查询，输出3
		System.out.println( Collections.binarySearch( nums, 3 ) );

	}

}
