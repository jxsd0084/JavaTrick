package bj.mldn.javase02.ch11.no15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		// 要求将里面的字符取出，也就是说按照数字拆分
		String  str       = "A1B22C333D4444E55555F";    // 指定好一个字符串
		String  pat       = "\\d+";                     // 指定好正则表达式

		Pattern p         = Pattern.compile( pat );     // 实例化Pattern类


		Matcher m         = p.matcher( str );           // 实例化Matcher类的对象


		String  newString = m.replaceAll( "_" );

		System.out.println( newString );



	}
}
