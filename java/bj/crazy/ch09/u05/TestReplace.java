package bj.crazy.ch09.u05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class TestReplace {

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

		Pattern p       = Pattern.compile( "re\\w*" );
		Matcher matcher = null;

		for ( int i = 0; i < msgs.length; i++ ) {

			if ( matcher == null ) {
				matcher = p.matcher( msgs[ i ] );

			} else {
				matcher.reset( msgs[ i ] );

			}

			System.out.println( matcher.replaceAll( "哈哈\2" ) );
		}

	}

}
