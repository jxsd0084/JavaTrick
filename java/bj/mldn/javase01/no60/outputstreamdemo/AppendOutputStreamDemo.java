package bj.mldn.javase01.no60.outputstreamdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class AppendOutputStreamDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File         file = new File( "d:" + File.separator + "demo.txt" ); // 要操作的文件
		OutputStream out  = null;               // 声明字节输出流
		out = new FileOutputStream( file, true ); // 通过子类实例化，表示追加
		String str = "hello world \r\n";        // 要输出的信息，“\r\n”表示换行
		byte   b[] = str.getBytes();            // 将String变为byte数组
		out.write( b );                           // 写入数据
		out.close();                            // 关闭
	}

}
