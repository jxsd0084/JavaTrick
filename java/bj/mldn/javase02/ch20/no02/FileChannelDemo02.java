package bj.mldn.javase02.ch20.no02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo02 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {

		File             file1  = new File( "d:" + File.separator + "note.txt" );
		File             file2  = new File( "d:" + File.separator + "outnote.txt" );
		FileInputStream  input  = null;
		FileOutputStream output = null;
		output = new FileOutputStream( file2 );
		input = new FileInputStream( file1 );
		FileChannel fout = null;        // 声明FileChannel对象
		FileChannel fin  = null;        // 定义输入的通道
		fout = output.getChannel();     // 得到输出的通道
		fin = input.getChannel();       // 得到输入的通道
		ByteBuffer buf = ByteBuffer.allocate( 1024 );

		int temp = 0;
		while ( ( temp = fin.read( buf ) ) != - 1 ) {
			buf.flip();
			fout.write( buf );
			buf.clear();                // 清空缓冲区,所有的状态变量的位置恢复到原点
		}
		fin.close();
		fout.close();
		input.close();
		output.close();
	}
}
