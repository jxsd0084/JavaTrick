package bj.mldn.javase01.no55.regextdemo;

import java.util.regex.Pattern;

public class PatternDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String  str   = "TOM:30|JERRY:31|PARK:32";
		String  regex = "\\|";

		Pattern pat   = Pattern.compile( regex ); // 执行拆分操作
		String  s1[]  = pat.split( str );         // 拆分
		for ( int i = 0; i < s1.length; i++ ) {

			System.out.println( s1[ i ] );          // 输出
		}

	}

}
