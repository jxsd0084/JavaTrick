package bj.mldn.javase02.ch12.no07;

import java.io.*;

public class PrintDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String arg[] ) throws Exception {

		PrintStream ps = null;        // 声明打印流对象

		// 如果现在是使用FileOuputStream实例化，意味着所有的输出是向文件之中
		ps = new PrintStream( new FileOutputStream( new File( "d:" + File.separator + "test.txt" ) ) );


		ps.print( "hello " );
		ps.println( "world!!!" );
		ps.print( "1 + 1 = " + 2 );


		ps.close();
	}

}
