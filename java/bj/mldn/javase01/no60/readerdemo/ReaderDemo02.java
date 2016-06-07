package bj.mldn.javase01.no60.readerdemo;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File   file  = new File( "d:" + File.separator + "demo.txt" ); // 要操作的文件
		Reader input = null;                        // 字节输入流
		input = new FileReader( file );               // 通过子类进行实例化操作
		char b[] = new char[ (int) file.length() ];   // 开辟空间接收读取的内容
		for ( int i = 0; i < b.length; i++ ) {
			b[ i ] = (char) input.read();             // 一个个的读取数据
		}
		System.out.println( new String( b ) );          // 输出内容，直接转换
		input.close();                              // 关闭
	}

}
