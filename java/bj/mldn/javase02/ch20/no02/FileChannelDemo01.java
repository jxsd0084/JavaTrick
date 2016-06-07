package bj.mldn.javase02.ch20.no02;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo01 {

	/**
	 * 测试
 	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {

		String           info[] = { "MLDN", "MLDNJAVA", "www.mldn.cn", "www.mldnjava.cn", "李兴华", "lixinghua" };
		File             file   = new File( "d:" + File.separator + "out.txt" );
		FileOutputStream output = null;
		output = new FileOutputStream( file );
		FileChannel fout = null;                // 声明FileChannel对象
		fout = output.getChannel();             // 得到输出的通道
		ByteBuffer buf = ByteBuffer.allocate( 1024 );
		for ( int i = 0; i < info.length; i++ ) {
			buf.put( info[ i ].getBytes() );    // 字符串变为字节数组放进缓冲区之中
		}
		buf.flip();
		fout.write( buf );                      // 输出缓冲区的内容
		fout.close();
		output.close();
	}
}
