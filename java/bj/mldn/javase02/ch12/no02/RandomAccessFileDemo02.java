package bj.mldn.javase02.ch12.no02;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo02 {

	// 所有的异常直接抛出，程序中不再进行处理
	public static void main( String args[] ) throws Exception {

		File             f   = new File( "d:" + File.separator + "test.txt" );    // 指定要操作的文件
		RandomAccessFile rdf = null;            // 声明RandomAccessFile类的对象
		rdf = new RandomAccessFile( f, "r" );   // 以只读的方式打开文件
		String name = null;
		int    age  = 0;
		byte   b[]  = new byte[ 8 ];    // 开辟byte数组

		// 读取第二个人的信息，意味着要空出第一个人的信息
		rdf.skipBytes( 12 );            // 跳过第一个人的信息
		for ( int i = 0; i < b.length; i++ ) {
			b[ i ] = rdf.readByte();    // 读取一个字节
		}

		name = new String( b );         // 将读取出来的byte数组变为字符串
		age = rdf.readInt();            // 读取数字
		System.out.println( "第二个人的信息 --> 姓名：" + name + "；年龄：" + age );

		// 读取第一个人的信息
		rdf.seek( 0 );                  // 指针回到文件的开头
		for ( int i = 0; i < b.length; i++ ) {
			b[ i ] = rdf.readByte();    // 读取一个字节
		}

		name = new String( b );         // 将读取出来的byte数组变为字符串
		age = rdf.readInt();            // 读取数字
		System.out.println( "第一个人的信息 --> 姓名：" + name + "；年龄：" + age );
		rdf.skipBytes( 12 );            // 空出第二个人的信息

		for ( int i = 0; i < b.length; i++ ) {
			b[ i ] = rdf.readByte();    // 读取一个字节
		}

		name = new String( b );         // 将读取出来的byte数组变为字符串
		age = rdf.readInt();            // 读取数字

		System.out.println( "第三个人的信息 --> 姓名：" + name + "；年龄：" + age );
		rdf.close();                    // 关闭
	}

}
