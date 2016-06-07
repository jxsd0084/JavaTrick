package bj.powernode.basic.day15.reflect.通过属性文件动态创建类的实例;

import java.io.*;
import java.util.*;

public class DynamicCreateInstance {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Properties p = new Properties();

		p.load( new FileInputStream( "classInfo.properties" ) );  // 相对路径,相对当前路径.

		String className = p.getProperty( "className" );


		// 通过反射获取类的基因信息.
		Class c = Class.forName( className );


		// 创建对象
		Object obj = c.newInstance();

		System.out.println( obj );


	}

}
