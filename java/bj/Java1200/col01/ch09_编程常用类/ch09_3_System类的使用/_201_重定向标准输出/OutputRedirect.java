package bj.Java1200.col01.ch09_编程常用类.ch09_3_System类的使用._201_重定向标准输出;

import java.io.*;

public class OutputRedirect {

	public static void main( String[] args ) throws IOException {

		File        file     = new File( "d:\\debug.txt" );// 创建一个文件来保存重定向后输出的文本信息
		PrintStream out      = new PrintStream( file );
		PrintStream cloneOut = System.out;// 使用变量保存控制台输出
		System.setOut( out );// 将标准输出重定向到PrintStream
		System.out.println( "明日科技新书快递：" );// 利用标准输出输出语句
		System.out.println( "Java从入门到精通（第2版）" );// 利用标准输出输出语句
		System.out.println( "视频学Java" );// 利用标准输出输出语句
		System.out.println( "细说Java" );// 利用标准输出输出语句
		out.close();// 关闭PrintStream
		System.setOut( cloneOut );// 将标准输出重定向到控制台
		BufferedReader in = new BufferedReader( new FileReader( file ) );// 读取文件
		String         line;
		while ( ( line = in.readLine() ) != null ) {
			System.out.println( line );// 在控制台上输出文件
		}
		in.close();// 关闭输入流
	}
}
