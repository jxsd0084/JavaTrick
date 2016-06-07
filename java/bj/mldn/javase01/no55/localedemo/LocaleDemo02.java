package bj.mldn.javase01.no55.localedemo;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Locale chLoc = new Locale( "zh", "CN" ); // 指定中文环境
		Locale enLoc = new Locale( "en", "US" ); // 指定英文环境

		// 要找到Message的属性文件，此时操作时省略了后缀，并指定了操作的区域
		ResourceBundle chRb    = ResourceBundle.getBundle( "Message", chLoc );
		ResourceBundle enRb    = ResourceBundle.getBundle( "Message", enLoc );

		String         zhValue = chRb.getString( "info" ); // 根据key找到内容
		String         enValue = enRb.getString( "info" ); // 根据key找到内容

		System.out.println( "中文内容为：" + zhValue );
		System.out.println( "英文内容为：" + enValue );

	}

}
