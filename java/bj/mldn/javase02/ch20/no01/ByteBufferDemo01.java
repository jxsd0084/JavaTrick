package bj.mldn.javase02.ch20.no01;

import java.nio.ByteBuffer;

public class ByteBufferDemo01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		ByteBuffer buf    = ByteBuffer.allocateDirect( 10 );    // 准备出10个大小的缓冲区
		byte       temp[] = { 1, 3, 5, 7, 9 };    // 设置内容
		buf.put( temp );                          // 设置一组内容
		buf.flip();

		System.out.print( "主缓冲区中的内容：" );
		while ( buf.hasRemaining() ) {
			int x = buf.get();
			System.out.print( x + "、" );
		}
	}
}
