package bj.mldn.javase01.no69.sytemiodemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectSystemErrDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File file = new File( "d:" + File.separator + "demo.txt" );
		System.setErr( new PrintStream( new FileOutputStream( file ) ) );
		System.err.println( "hello world" );
	}

}
