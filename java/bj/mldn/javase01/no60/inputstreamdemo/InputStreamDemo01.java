package bj.mldn.javase01.no60.inputstreamdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		File        file  = new File( "d:" + File.separator + "demo.txt" ); // 要操作的文件
		InputStream input = null;           // 字节输入流
		input = new FileInputStream( file );  // 通过子类进行实例化操作
		byte b[] = new byte[ 1024 ];          // 开辟空间接收读取的内容
		int  len = input.read( b );           // 将内容读入到byte数组中
		System.out.println( new String( b, 0, len ) ); // 输出内容
		input.close(); // 关闭
	}

}
