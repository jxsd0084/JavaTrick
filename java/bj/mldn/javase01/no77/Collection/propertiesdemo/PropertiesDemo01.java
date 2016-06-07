package bj.mldn.javase01.no77.Collection.propertiesdemo;

import java.util.Properties;

public class PropertiesDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Properties pro = new Properties();
		pro.setProperty( "BJ", "BeiJing" );
		pro.setProperty( "NJ", "NanJing" );
		pro.setProperty( "TJ", "TianJin" );
		System.out.println( "属性存在：" + pro.getProperty( "BJ" ) );
		System.out.println( "属性不存在：" + pro.getProperty( "SC" ) );
		System.out.println( "属性不存在，指定默认值：" + pro.getProperty( "SC", "没有此属性！" ) );
	}
}
