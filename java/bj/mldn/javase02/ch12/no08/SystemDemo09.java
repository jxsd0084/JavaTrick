package bj.mldn.javase02.ch12.no08;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SystemDemo09 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		System.setIn( new FileInputStream( "d:"
		                                   + File.separator + "demo.txt" ) );    // 设置输入重定向
		InputStream input = System.in;          // 从文件中接收数据
		byte        b[]   = new byte[ 1024 ];   // 开辟空间，接收数据
		int         len   = input.read( b );    //接收
		System.out.println( "输入的内容为：" + new String( b, 0, len ) );
		input.close();                          // 关闭输入流
	}
}
