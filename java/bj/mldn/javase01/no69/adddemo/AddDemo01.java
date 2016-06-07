package bj.mldn.javase01.no69.adddemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		BufferedReader buf = null;
		// 将字节输入流变为字符输入流放在字符流的缓冲区之中
		buf = new BufferedReader( new InputStreamReader( System.in ) );
		int    i   = 0; // 接收第一个数字
		int    j   = 0; // 接收第二个数字
		String str = null;
		System.out.print( "请输入第一个数字：" );
		try {
			str = buf.readLine();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		i = Integer.parseInt( str );
		System.out.print( "请输入第二个数字：" );
		try {
			str = buf.readLine();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		j = Integer.parseInt( str );
		System.out.println( "数字相加操作：" + i + " + " + j + " = " + ( i + j ) );
	}

}
