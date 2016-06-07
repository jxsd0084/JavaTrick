package bj.mldn.javase02.ch12.no14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		File         file       = new File( "d:" + File.separator + "mldn.zip" );    // 找到压缩文件
		File         outputFile = new File( "d:" + File.separator + "mldn_unzip.txt" ); // 定义解压缩的文件名称
		ZipFile      zipFile    = new ZipFile( file );    // 实例化ZipFile对象
		ZipEntry     entry      = zipFile.getEntry( "mldn.txt" );    // 得到一个压缩实体
		OutputStream out        = new FileOutputStream( outputFile ); // 实例化输出流
		InputStream  input      = zipFile.getInputStream( entry );    // 得到一个压缩实体的输入流
		int          temp       = 0;
		while ( ( temp = input.read() ) != - 1 ) {
			out.write( temp );
		}
		input.close();    // 关闭输入流
		out.close();    // 关闭输出流
	}
}
