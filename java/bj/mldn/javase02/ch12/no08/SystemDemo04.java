package bj.mldn.javase02.ch12.no08;

import java.io.InputStream;

public class SystemDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		InputStream input = System.in;        // 从键盘接收数据
		byte        b[]   = new byte[ 5 ];    // 开辟空间，接收数据
		System.out.print( "请输入内容：" );     // 提示信息
		int len = input.read( b );            // 接收数据
		System.out.println( "输入的内容为：" + new String( b, 0, len ) );
		input.close();                        // 关闭输入流
	}
}
