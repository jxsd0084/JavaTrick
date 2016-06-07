package bj.mldn.javase01.no69.bytearraydemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArraDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String                str = "helloworld";   // 定义字符串，全部由小写字母组成
		ByteArrayOutputStream bos = null;           // 内存输出流
		ByteArrayInputStream  bis = null;           // 内存输入流
		bis = new ByteArrayInputStream( str.getBytes() ); // 将内容保存在内存之中
		bos = new ByteArrayOutputStream();          // 内存输出流
		int temp = 0;
		while ( ( temp = bis.read() ) != - 1 ) {        // 依次读取
			char c = (char) temp;                   // 接收字符
			bos.write( Character.toUpperCase( c ) );    // 输出
		}
		String newStr = bos.toString();             // 取出内存输出的内容
		System.out.println( newStr );
	}

}
