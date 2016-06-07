package bj.mldn.javase01.no69.sytemiodemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ErrDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File file = new File( "d:" + File.separator + "err.log" );
		System.setOut( new PrintStream( new FileOutputStream( file ) ) );
		try {
			Integer.parseInt( "hello" );
		} catch ( Exception e ) {
			System.out.println( e );
			System.err.println( e );
		}
	}

}
