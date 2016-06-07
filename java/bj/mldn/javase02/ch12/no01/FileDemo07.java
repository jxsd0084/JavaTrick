package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		File f = new File( "d:" + File.separator + "mldn" );    // 实例化File类的对象

		f.mkdir();                                              // 创建文件夹

	}

}
