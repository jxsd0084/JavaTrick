package bj.mldn.javase02.ch11.no03;

import java.text.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class InterDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Locale zhLoc = new Locale( "zh", "CN" );        // 表示中国地区
		Locale enLoc = new Locale( "en", "US" );        // 表示美国地区
		Locale frLoc = new Locale( "fr", "FR" );        // 表示法国地区
		// 找到中文的属性文件，需要指定中文的Locale对象
		ResourceBundle zhrb = ResourceBundle.getBundle( "Message", zhLoc );
		// 找到英文的属性文件，需要指定英文的Locale对象
		ResourceBundle enrb = ResourceBundle.getBundle( "Message", enLoc );
		// 找到法文的属性文件，需要指定法文的Locale对象
		ResourceBundle frrb = ResourceBundle.getBundle( "Message", frLoc );
		// 依次读取各个属性文件的内容，通过键值读取，此时的键值名称统一为info
		String str1 = zhrb.getString( "info" );
		String str2 = enrb.getString( "info" );
		String str3 = frrb.getString( "info" );
		System.out.println( "中文：" + MessageFormat.format( str1, "李兴华" ) );
		System.out.println( "英语：" + MessageFormat.format( str2, "LiXingHua" ) );
		System.out.println( "法语：" + MessageFormat.format( str3, "LiXingHua" ) );
	}
}
