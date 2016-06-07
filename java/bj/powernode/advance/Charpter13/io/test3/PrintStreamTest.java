package bj.powernode.advance.Charpter13.io.test3;

import java.io.*;

public class PrintStreamTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		fun();
	}

	public static void fun() {

		FileOutputStream fout = null;
		PrintStream      ps   = null;
		try {
			fout = new FileOutputStream( "date.txt", true );
			ps = new PrintStream( fout );
			String s = "序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联";

			ps.println( s );
			ps.println( s );

			System.out.println( "文件写入成功" );

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} finally {
			if ( fout != null ) {
				try {
					fout.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}
}
