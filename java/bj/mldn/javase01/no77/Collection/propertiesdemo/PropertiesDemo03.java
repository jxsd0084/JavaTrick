package bj.mldn.javase01.no77.Collection.propertiesdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Properties pro = new Properties();
		try {
			pro.load( new FileInputStream( new File( "d:" + File.separator
			                                         + "area.properties" ) ) );
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		System.out.println( "属性存在：" + pro.getProperty( "BJ" ) );
		System.out.println( "属性不存在：" + pro.getProperty( "SC" ) );
		System.out.println( "属性不存在，指定默认值：" + pro.getProperty( "SC", "没有此属性！" ) );
	}
}
