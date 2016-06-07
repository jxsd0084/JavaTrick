package bj.powernode.basic.day14;

/*

	mark
	reset

*/

import java.io.*;

public class TestFileInputStream4 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		InputStream in = new FileInputStream( "D:\\course\\JavaProjects\\day14\\FirstFile" );

		System.out.println( in.markSupported() );   // 不支持标记.

		// 读.
		in.mark( 10 );

		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );

		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );


		// 调用reset
		in.reset();
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );
		System.out.println( (char) in.read() );

		in.close();

	}

}
