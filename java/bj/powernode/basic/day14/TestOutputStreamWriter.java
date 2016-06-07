package bj.powernode.basic.day14;

import java.io.*;

public class TestOutputStreamWriter {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		OutputStreamWriter osw = new OutputStreamWriter( new FileOutputStream( "D:/course/JavaProjects/day14/tempFile03" ) );


		osw.write( "hello world" );

		osw.flush();

		osw.close();

	}

}
