package bj.crazy.ch09.u05;

import java.util.Arrays;

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

public class StringReg {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		String[] msgs =
				{
						"Java has regular expressions in 1.4",
						"regular expressions now expressing in Java",
						"Java represses oracular expressions"
				};
		for ( String msg : msgs ) {

			System.out.println( msg.replaceFirst( "re\\w*", "哈哈\1" ) );

			System.out.println( Arrays.toString( msg.split( " " ) ) );
		}

	}

}
