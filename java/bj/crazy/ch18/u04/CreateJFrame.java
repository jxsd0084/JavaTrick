package bj.crazy.ch18.u04;

import java.lang.reflect.*;

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
public class CreateJFrame {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {


		// 获取JFrame对应的Class对象

		Class< ? > jframeClazz = Class.forName( "javax.swing.JFrame" );






		// 获取JFrame中带一个字符串参数的构造器

		Constructor ctor = jframeClazz.getConstructor( String.class );






		// 调用Constructor的newInstance方法创建对象

		Object obj = ctor.newInstance( "测试窗口" );






		// 输出JFrame对象

		System.out.println( obj );





	}

}
