package bj.crazy.ch09.u02;

import java.io.*;
import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestSystem {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		// 获取系统所有的环境变量

		Map< String, String > env = System.getenv();
		for ( String name : env.keySet() ) {

			System.out.println( name + " ------> " + env.get( name ) );
		}




		// 获取指定环境变量的值

		System.out.println( System.getenv( "JAVA_HOME" ) );




		// 获取所有的系统属性

		Properties props = System.getProperties();

		// 将所有系统属性保存到props.txt文件中

		props.store( new FileOutputStream( "props.txt" ), "System Properties" );

		// 输出特定的系统属性

		System.out.println( System.getProperty( "os.name" ) );






	}
}
