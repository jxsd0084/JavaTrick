package bj.mldn.javase01.no69.sytemiodemo;

import java.io.OutputStream;

public class SysteOutDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		OutputStream out = System.out;          // 此时具备了向屏幕输出的能力
		out.write( "hello world".getBytes() );    // 输出内容
		out.close();
	}

}
