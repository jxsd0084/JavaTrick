package bj.mldn.javase01.no60.filedemo;

import java.io.File;

public class DeleteFileDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		File file = new File( "d:\\demo.txt" ); // 找到File类的实例
		file.delete();// 删除文件
	}

}
