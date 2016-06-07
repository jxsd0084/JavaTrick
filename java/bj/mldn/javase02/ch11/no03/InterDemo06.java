package bj.mldn.javase02.ch11.no03;

import java.text.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class InterDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Locale zhLoc = new Locale( "zh", "CN" );        // 表示中国地区
		// 找到中文的属性文件，需要指定中文的Locale对象
		ResourceBundle zhrb = ResourceBundle.getBundle( "Message", zhLoc );
		String         str1 = zhrb.getString( "info" );
		System.out.println( "中文:" + MessageFormat.format( str1, "李兴华" ) );

	}

}
