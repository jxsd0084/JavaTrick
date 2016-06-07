package bj.crazy.ch09.u01;

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
public class TestArgs {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( args.length );
		for ( String arg : args ) {

			System.out.println( arg );
		}

	}

}
