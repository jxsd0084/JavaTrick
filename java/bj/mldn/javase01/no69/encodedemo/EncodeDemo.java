package bj.mldn.javase01.no69.encodedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class EncodeDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		OutputStream output = new FileOutputStream( new File( "d:"
		                                                      + File.separator + "test.txt" ) );
		String str = "中国，你好！";
		output.write( str.getBytes( "ISO8859-1" ) );
		output.close();
	}

}
