package bj.crazy.ch17.u03.HalfClose;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Client {

	/**
	 * 测试
	 * @param args
	 * @throws IOException
	 */
	public static void main( String[] args ) throws IOException {

		Socket  s    = new Socket( "localhost", 30000 );

		Scanner scan = new Scanner( s.getInputStream() );
		if ( scan.hasNextLine() ) {
			System.out.println( scan.nextLine() );
		}




		PrintStream ps = new PrintStream( s.getOutputStream() );


		ps.println( "客户端的第一行数据" );
		ps.println( "客户端的第二行数据" );




		ps.close();
		scan.close();
		s.close();




	}
}
