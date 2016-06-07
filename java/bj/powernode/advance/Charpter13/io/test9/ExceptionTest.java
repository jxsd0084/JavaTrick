package bj.powernode.advance.Charpter13.io.test9;

import java.io.*;

public class ExceptionTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			// 用于读取诸如图像数据之类的原始字节流/FileInputStream(String
			// name)--通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定
			FileInputStream fin = new FileInputStream( "c://aaa.txt" );

		} catch ( FileNotFoundException e ) {

			// e.printStackTrace();
			// printException--封装了与打印有关的错误状况,仅提供对该错误的字符串描述
			Logger.printException( e );
		}

	}

}
