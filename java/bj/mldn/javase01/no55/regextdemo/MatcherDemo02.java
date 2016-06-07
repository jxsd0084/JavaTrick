package bj.mldn.javase01.no55.regextdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		String  str   = "1ss34fsdafsd567fsdafsd";   // 字符串由数字组成
		String  regex = "\\d+";

		Matcher mat   = Pattern.compile( regex ).matcher( str );

		System.out.println( mat.replaceAll( "Ｏ" ) );    // 替换

	}

}
