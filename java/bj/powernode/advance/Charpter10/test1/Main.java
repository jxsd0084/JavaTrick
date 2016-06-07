package bj.powernode.advance.Charpter10.test1;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "HelloWorld" );
		PrintStream ps = System.out;
		ps.println( "HelloWorld" );





		Scanner sc = new Scanner( System.in );
		String  s  = sc.next();
		System.out.println( "你输入的数据是:" + s );







		String s1 = null;
		while ( ( s1 = sc.next() ) != null && ! "".equals( s1 ) ) {

			if ( "exit".equalsIgnoreCase( s1 ) ) {

				break;
			}

			System.out.println( "接受的数据是:" + s1 );
		}
		System.out.println( "程序要结束了!886" );





		System.err.print( "djsflkdjsflkjdsfkldj" );
		System.err.print( "FLDSJFKFJDSL" );






		double d1 = Math.ceil( 3.4 );
		double d2 = Math.floor( 3.4 );

		double d3 = Math.rint( 3.5 );
		System.out.println( d3 );





	}

}
