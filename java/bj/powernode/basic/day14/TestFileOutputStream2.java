package bj.powernode.basic.day14;

import java.io.*;

public class TestFileOutputStream2 {

	//HelloWorld 写入文件

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		OutputStream os = new FileOutputStream( "D:/course/JavaProjects/day14/SecondFile" );

		String content = "HelloWorld";

		// 写
		byte[] bytes = content.getBytes();
		os.write( bytes );

		os.flush();

		os.close();

	}

}
