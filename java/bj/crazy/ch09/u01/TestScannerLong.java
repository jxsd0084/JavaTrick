package bj.crazy.ch09.u01;

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
public class TestScannerLong {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// System.in代表标准输入，就是键盘输入
		Scanner sc = new Scanner( System.in );

		// 判断是否还有下一个long整数
		while ( sc.hasNextLong() ) {

			// 输出输入项
			System.out.println( "键盘输入的内容是：" + sc.nextLong() );
		}



	}

}
