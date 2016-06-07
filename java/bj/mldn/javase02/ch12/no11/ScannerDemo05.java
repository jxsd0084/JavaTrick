package bj.mldn.javase02.ch12.no11;

import java.io.File;
import java.util.Scanner;

public class ScannerDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		File    f    = new File( "D:" + File.separator + "test.txt" );    // 指定操作文件
		Scanner scan = null;
		try {
			scan = new Scanner( f );    // 从键盘接收数据
		} catch ( Exception e ) {
		}
		StringBuffer str = new StringBuffer();
		while ( scan.hasNext() ) {
			str.append( scan.next() ).append( '\n' );    //	取数据
		}
		System.out.println( "文件内容为：" + str );
	}
}
