package bj.crazy.ch18.u02;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ClassLoaderPropTest {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main( String[] args ) throws IOException {




		// 获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();

		System.out.println( "系统类加载器：" + systemLoader );





		/*
			获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定

			如果操作系统没有指定CLASSPATH环境变量，默认以当前路径作为

			系统类加载器的加载路径
		*/

		Enumeration< URL > em1 = systemLoader.getResources( "" );
		while ( em1.hasMoreElements() ) {
			System.out.println( em1.nextElement() );
		}





		// 获取系统类加载器的父类加载器——应该得到扩展类加载器

		ClassLoader extensionLader = systemLoader.getParent();


		System.out.println( "扩展类加载器："
		                    + extensionLader );


		System.out.println( "扩展类加载器的加载路径："
		                    + System.getProperty( "java.ext.dirs" ) );


		System.out.println( "扩展类加载器的parent: "
		                    + extensionLader.getParent() );







	}

}
