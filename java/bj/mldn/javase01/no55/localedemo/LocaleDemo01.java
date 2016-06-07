package bj.mldn.javase01.no55.localedemo;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Locale loc = Locale.getDefault(); // 得到默认的Locale

		// 要找到Message的属性文件，此时操作时省略了后缀，并指定了操作的区域
		ResourceBundle rb    = ResourceBundle.getBundle( "Message", loc );

		String         value = rb.getString( "info" );    // 根据key找到内容

		System.out.println( "内容为：" + value );

	}

}
