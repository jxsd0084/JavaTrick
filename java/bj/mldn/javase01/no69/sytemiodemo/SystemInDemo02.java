package bj.mldn.javase01.no69.sytemiodemo;

import java.io.InputStream;

public class SystemInDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		InputStream input = System.in;   // 准备键盘输入数据
		byte        b[]   = new byte[ 5 ]; // 开辟空间接收内容
		System.out.print( "请输入内容：" );
		int len = input.read( b );         // 接收内容
		System.out.println( "输入的内容是：" + new String( b, 0, len ) );
	}
}
