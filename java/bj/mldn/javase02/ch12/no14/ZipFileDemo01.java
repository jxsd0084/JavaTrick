package bj.mldn.javase02.ch12.no14;

import java.io.File;
import java.util.zip.ZipFile;

public class ZipFileDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		File    file    = new File( "d:" + File.separator + "mldn.zip" );    // 找到压缩文件
		ZipFile zipFile = new ZipFile( file );    // 实例化ZipFile对象
		System.out.println( "压缩文件的名称：" + zipFile.getName() );    // 得到压缩文件的名称
	}
}
