package bj.mldn.javase02.ch12.no13;

import java.io.*;

public class SequenceDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		InputStream         is1 = null;        // 输入流1
		InputStream         is2 = null;        // 输入流1
		OutputStream        os  = null;        // 输出流
		SequenceInputStream sis = null;    // 合并流
		is1 = new FileInputStream( "d:" + File.separator + "a.txt" );
		is2 = new FileInputStream( "d:" + File.separator + "b.txt" );
		os = new FileOutputStream( "d:" + File.separator + "ab.txt" );
		sis = new SequenceInputStream( is1, is2 );    // 实例化合并流
		int temp = 0;    // 接收内容
		while ( ( temp = sis.read() ) != -1 ) {    // 循环输出
			os.write( temp );    // 保存内容
		}
		sis.close();    // 关闭合并流
		is1.close();    // 关闭输入流1`
		is2.close();    // 关闭输入流2
		os.close();    // 关闭输出流
	}
}
