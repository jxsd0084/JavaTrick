package bj.powernode.basic.day15;

import java.io.*;


public class TestRandomAccessFile {


	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建RandomAccessFile对象
		RandomAccessFile r = new RandomAccessFile( "D:/course/JavaProjects/day15/tempFile03", "rw" );



		// 2.写入数据
		r.write( new byte[]{ 97, 98, 99, 100, 65, 66, 67, 68 } );  //a b c d A B C D


		// 3.将文件指针偏移量设置成 2
		r.seek( 2 );

		r.write( new byte[]{ 101, 101, 101 } );  // a b e e e B C D




		// 4.获取文件指针的偏移量值
		System.out.println( r.getFilePointer() );  //5




		// 5.获取文件的长度.
		System.out.println( r.length() ); // 8

		System.out.println( r.getFilePointer() );  //5





		// 6.读取.
		byte b = r.readByte();
		System.out.println( b );

		byte b1 = r.readByte();
		System.out.println( b1 );

		byte b2 = r.readByte();
		System.out.println( b2 );
		
		/*
			byte b3 = r.readByte();
			System.out.println(b3);
		*/


		r.close();


	}

}
