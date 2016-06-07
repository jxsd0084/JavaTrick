package bj.mldn.javase02.ch12.no14;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		File           zipFile = new File( "d:" + File.separator + "mldn.zip" );    // 定义压缩文件名称
		ZipInputStream input   = null;    // 定义压缩输入流
		input = new ZipInputStream( new FileInputStream( zipFile ) );    // 实例化ZIpInputStream
		ZipEntry entry = input.getNextEntry();    // 得到一个压缩实体
		System.out.println( "压缩实体名称：" + entry.getName() );
		input.close();
	}
}
