package bj.powernode.basic.day15;

import java.util.Properties;


/*

	回顾java.util.Properties

	属性类 (key, value),key和value都是字符串

	向属性对象中存数据. properties.setProperty(key,value);
	从属性对象中取数据. String value = properties.getProperty(key);

*/

public class TestProperties {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		// 1.创建属性对象
		Properties p = new Properties();




		// 2.存
		p.setProperty( "url", "http://www.baidu.com" );
		p.setProperty( "classname", "java.util.Properties" );
		p.setProperty( "username", "administrator" );
		p.setProperty( "password", "123" );




		// 3.取(通过key获取value)
		String urlValue  = p.getProperty( "url" );
		String classname = p.getProperty( "classname" );
		String username  = p.getProperty( "username" );
		String password  = p.getProperty( "password" );




		System.out.println( urlValue );
		System.out.println( classname );
		System.out.println( username );
		System.out.println( password );


	}

}
