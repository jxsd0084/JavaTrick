package bj.mldn.javase02.ch12.no01;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		File f = new File( "d:\\test.txt" );        // 实例化File类的对象
		try {
			f.createNewFile();                      // 创建文件，根据给定的路径创建
		} catch ( IOException e ) {
			e.printStackTrace();                    // 输出异常信息
		}
	}
}