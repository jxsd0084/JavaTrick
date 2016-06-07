package bj.powernode.basic.day14;

import java.io.*;

public class TestFileWriter {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Writer w = new FileWriter( "D:/course/JavaProjects/day14/tempFile02" );

		// 写
		char[] chars = { 'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd', '\n' };
		w.write( chars );

		w.write( "HelloWorld\n" );

		w.append( "HelloWorld" );

		w.flush();

		w.close();


	}

}
