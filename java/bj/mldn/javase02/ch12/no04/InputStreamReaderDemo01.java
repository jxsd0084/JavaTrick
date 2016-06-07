package bj.mldn.javase02.ch12.no04;

import java.io.*;

public class InputStreamReaderDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		File   f      = new File( "d:" + File.separator + "test.txt" );
		Reader reader = null;
		reader = new InputStreamReader( new FileInputStream( f ) );     // 将字节流变为字符流
		char c[] = new char[ 1024 ];
		int  len = reader.read( c );                                    // 读取
		reader.close();                                                 // 关闭
		System.out.println( new String( c, 0, len ) );
	}
}
