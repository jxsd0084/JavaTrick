package bj.crazy.ch04.u03;

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
public class TestFor2 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 同时定义了三个初始化变量，使用 && 来组合多个boolean表达式
		for ( int b = 0, s = 0, p = 0;

				b < 10 && s < 4 && p < 10;

				p++ ) {


			System.out.println( b++ );

			System.out.println( ++ s + p );
		}

	}

}
