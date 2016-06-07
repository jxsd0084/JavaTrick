package bj.crazy.ch05.u02;

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
public class OverloadVarargs {

	public void test( String msg ) {

		System.out.println( "只有一个字符串参数的test方法 " );
	}

	// 因为前面已经有了一个test方法，test方法里有一个字符串参数。

	// 此处的长度可变形参里不包含一个字符串参数的形式
	public void test( String... books ) {

		System.out.println( "*******形参长度可变的test方法****** " );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		OverloadVarargs olv = new OverloadVarargs();

		// 下面两次调用将执行第二个test方法
		olv.test();

		olv.test( "aa", "bb" );

		// 下面将执行 第一个test方法
		olv.test( "aa" );

		// 下面将执行 第二个test方法
		olv.test( new String[]{ "aa" } );

	}

}
