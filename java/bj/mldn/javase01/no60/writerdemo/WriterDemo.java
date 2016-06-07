package bj.mldn.javase01.no60.writerdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File   file = new File( "d:" + File.separator + "demo.txt" ); // 要操作的文件
		Writer out  = null;             // 声明字符输出流
		out = new FileWriter( file );     // 通过子类实例化
		String str = "hello world";     // 要输出的信息
		out.write( str );                 // 写入数据
		out.flush();                    // 刷新
	}

}
