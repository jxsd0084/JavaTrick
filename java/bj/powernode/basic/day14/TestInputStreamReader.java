package bj.powernode.basic.day14;
/*
	
	测试InputStreamReader

*/

import java.io.*;

public class TestInputStreamReader {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建字节输入流 (节点流)
		InputStream in = new FileInputStream( "D:/course/JavaProjects/day14/TestFileInputStream3.java" );

		// 2.将字节输入流包装成字符输入流
		InputStreamReader isr = new InputStreamReader( in );        // 处理流

		System.out.println( "字符编码方式:" + isr.getEncoding() );    // GBK

		// 3.读

		int    temp  = 0;
		char[] chars = new char[ 512 ];
		while ( ( temp = isr.read( chars ) ) != - 1 ) {

			System.out.print( new String( chars, 0, temp ) );
		}

		// 4.关闭
		isr.close();

	}

}
