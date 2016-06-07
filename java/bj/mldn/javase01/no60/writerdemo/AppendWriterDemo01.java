package bj.mldn.javase01.no60.writerdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class AppendWriterDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File   file = new File( "d:" + File.separator + "demo.txt" ); // 要操作的文件
		Writer out  = null;                 // 声明字符输出流
		out = new FileWriter( file, true );   // 通过子类实例化，表示可以追加
		String str = "hello world\r\n";     // 要输出的信息
		out.write( str );                     // 写入数据
		out.close();                        // 关闭
	}

}
