package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		File f = new File( "d:" + File.separator + "test.txt" );    // 实例化File类的对象

		f.delete();                                                 // 删除文件

	}

}
