package bj.powernode.advance.Charpter05.test3;

import java.io.IOException;

public class TestRuntime {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Runtime r = Runtime.getRuntime();

		try {

			r.exec( "notepad" );

			long l = r.freeMemory();

			r.gc();
			System.out.println( l );

		} catch ( IOException e ) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
