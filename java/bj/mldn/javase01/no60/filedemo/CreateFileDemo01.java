package bj.mldn.javase01.no60.filedemo;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		File file = new File( "d:\\demo.txt" ); // 找到File类的实例
		try {
			file.createNewFile(); // 创建文件
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
