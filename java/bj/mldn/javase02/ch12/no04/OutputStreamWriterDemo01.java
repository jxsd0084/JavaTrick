package bj.mldn.javase02.ch12.no04;

import java.io.*;

public class OutputStreamWriterDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {       // 所有异常抛出
		File   f   = new File( "d:" + File.separator + "test.txt" );
		Writer out = null;                                            // 字符输出流
		out = new OutputStreamWriter( new FileOutputStream( f ) );    // 字节流变为字符流
		out.write( "hello world!!" );                                 // 使用字符流输出
		out.close();
	}
}
