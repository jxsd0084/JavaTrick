package bj.mldn.javase02.ch12.no11;

import java.text.*;
import java.util.*;

public class ScannerDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Scanner scan = new Scanner( System.in );    // 从键盘接收数据
		String  str  = null;
		Date    date = null;
		System.out.print( "输入日期（yyyy-MM-dd）：" );
		if ( scan.hasNext( "^\\d{4}-\\d{2}-\\d{2}$" ) ) {    // 判断
			str = scan.next( "^\\d{4}-\\d{2}-\\d{2}$" );    // 接收
			try {
				date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( str );
			} catch ( Exception e ) {
			}
		} else {
			System.out.println( "输入的日期格式错误！" );
		}
		System.out.println( date );
	}
}
