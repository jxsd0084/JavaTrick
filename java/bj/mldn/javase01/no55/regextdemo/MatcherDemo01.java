package bj.mldn.javase01.no55.regextdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String  str   = "1234567";  // 字符串由数字组成
		String  regex = "\\d+";

		Matcher mat   = Pattern.compile( regex ).matcher( str );
		if ( mat.matches() ) {        // 执行验证
			System.out.println( "字符串由数字组成！" );

		} else {
			System.out.println( "字符串由非数字组成！" );
		}

	}

}
