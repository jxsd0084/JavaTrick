package bj.mldn.javase01.no60.randomaccessdemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {                   // 所有异常抛出
		File             file = new File( "d:" + File.separator + "demo.txt" );   // 指定要操作的文件
		RandomAccessFile raf  = new RandomAccessFile( file, "r" );                // 以读的形式进行操作
		byte             b[]  = null;   // 定义字节数组
		String           name = null;
		int              age  = 0;
		b = new byte[ 8 ];
		raf.skipBytes( 12 ); // 跨过第一个人的信息
		System.out.println( "第二个人的信息：" );
		for ( int i = 0; i < 8; i++ ) {
			b[ i ] = raf.readByte(); // 读取字节
		}
		age = raf.readInt();// 读取数字
		System.out.println( "\t|- 姓名：" + new String( b ) );
		System.out.println( "\t|- 年龄：" + age );
		raf.seek( 0 );    // 回到开始位置
		System.out.println( "第一个人的信息：" );
		for ( int i = 0; i < 8; i++ ) {
			b[ i ] = raf.readByte(); // 读取字节
		}
		age = raf.readInt();    // 读取数字
		System.out.println( "\t|- 姓名：" + new String( b ) );
		System.out.println( "\t|- 年龄：" + age );
		raf.skipBytes( 12 ); // 跨过第二个人的信息
		System.out.println( "第三个人的信息：" );
		for ( int i = 0; i < 8; i++ ) {
			b[ i ] = raf.readByte(); // 读取字节
		}
		age = raf.readInt();    // 读取数字
		System.out.println( "\t|- 姓名：" + new String( b ) );
		System.out.println( "\t|- 年龄：" + age );
		raf.close();    // 文件操作的最后一定要关闭
	}
}
