package bj.powernode.basic.day12;

import java.util.Properties;

public class TestProperties {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		//1.创建属性对象
		Properties p = new Properties();


		//2.添加数据
		p.setProperty( "url", "jdbc:oralce:thin:@127.0.0.1:1521:dlpowernode" );


		//3.通过key获取value
		String value = p.getProperty( "url" );

		System.out.println( value );


	}


}
