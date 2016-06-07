package bj.powernode.advance.Charpter13.io.test9;

import java.io.*;

public class Logger {

	public static void printException( Throwable t ) {

		// PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式,打印的所有字符都使用平台的默认字符编码转换为字节
		PrintStream ps = null;

		// 用于写入诸如图像数据之类的原始字节的流
		FileOutputStream fout = null;

		try {

			// FileOutputStream(File file, boolean append)--如果为
			// true，则将字节写入文件末尾处，而不是写入文件开始处
			fout = new FileOutputStream( "log.txt", true );

			// 将低级流包装成高级流
			ps = new PrintStream( fout );

			t.printStackTrace( ps );

		} catch ( FileNotFoundException e ) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
