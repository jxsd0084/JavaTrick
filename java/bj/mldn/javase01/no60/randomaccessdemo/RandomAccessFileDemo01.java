package bj.mldn.javase01.no60.randomaccessdemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {   // 所有异常抛出
		File             file = new File( "d:" + File.separator + "demo.txt" );   // 指定要操作的文件
		RandomAccessFile raf  = new RandomAccessFile( file, "rw" );               // 以读写的形式进行操作
		// 写入第一条数据
		String name = "zhangsan";   // 表示姓名
		int    age  = 30;           // 表示年龄
		raf.writeBytes( name );       // 以字节的方式将字符串写入
		raf.writeInt( age );          // 写入整型数据
		// 写入第二条数据
		name = "lisi    ";          // 表示姓名
		age = 31; // 表示年龄
		raf.writeBytes( name );       // 以字节的方式将字符串写入
		raf.writeInt( age );          // 写入整型数据
		// 写入第三条数据
		name = "wangwu  ";          // 表示姓名
		age = 32; // 表示年龄
		raf.writeBytes( name );       // 以字节的方式将字符串写入
		raf.writeInt( age );          // 写入整型数据
		raf.close();                // 文件操作的最后一定要关闭
	}

}
