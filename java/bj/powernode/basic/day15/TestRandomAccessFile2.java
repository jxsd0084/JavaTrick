package bj.powernode.basic.day15;

import java.io.*;


public class TestRandomAccessFile2 {


	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		//1.创建RandomAccessFile对象
		RandomAccessFile r = new RandomAccessFile( "D:/course/JavaProjects/day15/tempFile04", "rw" );




		//2.写入数据
		r.writeUTF( "abcde" );

		r.writeUTF( "fghijklmnopqrstuvwxyz" );




		//3.读取字符串  (B/S)
		System.out.println( r.getFilePointer() );

		r.seek( 5 );   // 文件开头测量到的文件指针偏移量  1 byte





		System.out.println( r.readByte() );     // 100
		System.out.println( r.readByte() );     // 101
		System.out.println( r.readByte() );     // 0
		System.out.println( r.readByte() );     // 21




		r.close();


	}


}
