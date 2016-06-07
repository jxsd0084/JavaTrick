package bj.mldn.javase02.ch12.no11;

import java.util.*;

public class ScannerDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Scanner scan = new Scanner( System.in );    // 从键盘接收数据
		System.out.print( "输入数据：" );
		String str = scan.next();    // 接收数据
		System.out.println( "输入的数据为：" + str );
	}
}
