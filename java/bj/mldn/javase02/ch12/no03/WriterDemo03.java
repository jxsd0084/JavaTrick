package bj.mldn.javase02.ch12.no03;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {     // 异常抛出，不处理

		// 第1步、使用File类找到一个文件
		File f = new File( "d:" + File.separator + "test.txt" );    // 声明File对象

		// 第2步、通过子类实例化父类对象
		Writer out = null;                                          // 准备好一个输出的对象
		out = new FileWriter( f );                                  // 通过对象多态性，进行实例化

		// 第3步、进行写操作
		String str = "Hello World!!!";                              // 准备一个字符串
		out.write( str );                                           // 将内容输出，保存文件

		// 第4步、关闭输出流
		// out.close() ;						                    // 此时，没有关闭
	}
}
