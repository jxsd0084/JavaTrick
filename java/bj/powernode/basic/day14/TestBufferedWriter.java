package bj.powernode.basic.day14;

import java.io.*;

public class TestBufferedWriter {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( "D:/course/JavaProjects/day14/tempFile04" ) ) );

		// 写
		bw.write( "fdsafdsafjkdl;sjgklfd;jklf;djsliajfkldsajkflds" );

		bw.flush();

		bw.close();

	}

}
