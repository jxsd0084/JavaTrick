package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_3_文件控制._452;

import java.io.*;
import java.nio.channels.FileLock;

public class EncryptInput {

	public static void fileLock( String file ) {

		FileOutputStream fous = null; // 创建FileOutputStream对象
		FileLock         lock = null; // 创建FileLock对象
		try {
			fous = new FileOutputStream( file ); // 实例化FileOutputStream对象
			lock = fous.getChannel().tryLock(); // 获取文件锁定
			Thread.sleep( 60 * 1000 ); // 线程锁定1分钟
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) {

		String file = "C://count.txt"; // 创建文件对象
		fileLock( file ); // 调用文件锁定方法
	}
}
