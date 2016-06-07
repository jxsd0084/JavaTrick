package bj.mldn.javase02.ch12.no03;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 异常抛出，不处理

		// 第1步、使用File类找到一个文件
		File f = new File( "d:" + File.separator + "test.txt" );    // 声明File对象


		// 第2步、通过子类实例化父类对象
		Reader input = null;            // 准备好一个输入的对象
		input = new FileReader( f );    // 通过对象多态性，进行实例化


		// 第3步、进行读操作
		char c[]  = new char[ 1024 ];        // 所有的内容都读到此数组之中
		int  temp = 0;    // 接收每一个内容
		int  len  = 0;        // 读取内容
		while ( ( temp = input.read() ) != - 1 ) {
			// 如果不是-1就表示还有内容，可以继续读取
			c[ len ] = (char) temp;
			len++;
		}


		// 第4步、关闭输出流
		input.close();                        // 关闭输出流
		System.out.println( "内容为：" + new String( c, 0, len ) );    // 把字符数组变为字符串输出


	}
}
