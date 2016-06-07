package bj.mldn.javase01.no60.filedemo;

import java.io.File;
import java.io.IOException;

public class CreateDeleteFileDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		File file = new File( "d:" + File.separator + "demo.txt" ); // 找到File类的实例

		if ( file.exists() ) {// 如果文件存在
			file.delete();
		} else { // 文件不存在删除
			try {
				file.createNewFile(); // 创建文件
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

}
