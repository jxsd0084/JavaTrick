package bj.mldn.javase01.no69.printdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File        file  = new File( "d:" + File.separator + "demo.txt" );
		PrintStream out   = new PrintStream( new FileOutputStream( file ) );
		String      name  = "李兴华";
		int         age   = 3;
		float       score = 99.9f;
		char        sex   = 'M';
		out.printf( "姓名：%s；年龄：%d；成绩：%5.2f；性别：%c。", name, age, score, sex );
		out.close();
	}

}
