package bj.crazy.ch09.u06;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 取得系统默认的国家/语言环境
		Locale myLocale = Locale.getDefault();



		// 根据指定国家/语言环境加载资源文件
		ResourceBundle bundle = ResourceBundle.getBundle( "mess", myLocale );



		// 打印从资源文件中取得的消息
		System.out.println( bundle.getString( "hello" ) );



	}

}
