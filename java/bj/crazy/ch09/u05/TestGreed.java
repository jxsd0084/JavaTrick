package bj.crazy.ch09.u05;

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
public class TestGreed {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		String str = "hello , java!";

		System.out.println( str.replaceFirst( "\\w*", "■" ) );

		System.out.println( str.replaceFirst( "\\w*?", "■" ) );

	}

}