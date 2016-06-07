package bj.mldn.javase01.no69.sytemiodemo;

import java.io.InputStream;

public class SystemInDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		InputStream input = System.in;  // 准备键盘输入数据
		System.out.print( "请输入内容：" );
		int          temp = 0;          // 接收内容
		StringBuffer buf  = new StringBuffer();
		while ( ( temp = input.read() ) != - 1 ) {
			char c = (char) temp;       // 转型
			if ( c == '\n' ) {            // 判断是否是回车
				break;                  // 退出循环
			}
			buf.append( c );
		}
		System.out.println( "输入的内容是：" + buf );
	}
}
