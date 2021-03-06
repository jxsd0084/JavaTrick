package bj.mldn.javase02.ch12.no03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {     // 异常抛出，不处理

		// 第1步、使用File类找到一个文件
		File f = new File( "d:" + File.separator + "test.txt" );    // 声明File对象


		// 第2步、通过子类实例化父类对象
		OutputStream out = null;                                    // 准备好一个输出的对象
		out = new FileOutputStream( f, true );                      // 此处表示在文件末尾追加内容


		// 第3步、进行写操作
		String str = "Hello World!!!";                              // 准备一个字符串
		byte   b[] = str.getBytes();                                // 只能输出byte数组，所以将字符串变为byte数组
		for ( int i = 0; i < b.length; i++ ) {                      // 采用循环方式写入
			out.write( b[ i ] );                                    // 每次只写入一个内容
		}


		// 第4步、关闭输出流
		out.close();                                                // 关闭输出流


	}


}
