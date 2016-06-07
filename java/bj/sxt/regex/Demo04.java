package bj.sxt.regex;

import java.util.Arrays;

/**
 * 测试正则表达式对象的分割字符串的操作
 *
 * @author Administrator
 */
public class Demo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		String   str  = "a232b4334c3434";
		String[] arrs = str.split( "\\d+" );
		System.out.println( Arrays.toString( arrs ) );

	}

}
