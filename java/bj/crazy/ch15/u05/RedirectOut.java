package bj.crazy.ch15.u05;

import java.io.*;

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
public class RedirectOut {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		PrintStream ps = null;

		try {

			ps = new PrintStream( new FileOutputStream( "out.txt" ) );

			// 将标准输出重定向到ps输出流
			System.setOut( ps );

			// 向标准输出输出一个字符串
			System.out.println( "普通字符串" );

			// 向标准输出输出一个对象
			System.out.println( new RedirectOut() );

		} catch ( IOException ex ) {

			ex.printStackTrace();
		} finally {

			if ( ps != null ) {

				ps.close();
			}

		}

	}

}
