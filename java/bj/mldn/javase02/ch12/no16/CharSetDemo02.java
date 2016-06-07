package bj.mldn.javase02.ch12.no16;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CharSetDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		File         f   = new File( "D:" + File.separator + "test.txt" );    // 实例化File类
		OutputStream out = new FileOutputStream( f );    // 实例化输出流
		byte         b[] = "中国，你好！".getBytes( "ISO8859-1" );    // 转码操作
		out.write( b );    // 保存
		out.close();    // 关闭
	}
}
