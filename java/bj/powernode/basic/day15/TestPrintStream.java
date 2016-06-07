package bj.powernode.basic.day15;

import java.io.*;

/*

	PrintStream (不需要程序员关闭)

*/
public class TestPrintStream {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.向控制台打印信息  (输出到控制台.)
		System.out.println( "Hello World." );

		PrintStream ps = System.out;
		ps.println( "Hello World." );




		// 2.用PrintStream输出到文件.
		PrintStream ps2 = new PrintStream( "D:/course/JavaProjects/day15/tempFile01" );

		ps2.print( "a" );
		ps2.println( "b" );
		ps2.println( "cde" );





		// 3.System.setOut(PrintStream ps)方法的使用.
		System.setOut( new PrintStream( "D:/course/JavaProjects/day15/tempFile02" ) );
		System.out.println( "aaa" ); // 会往控制台打印吗?
		System.out.println( "bbb" );
		System.out.print( "ddd" );


	}

}
