package bj.mldn.javase02.ch12.no17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class SerDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		File              f     = new File( "D:" + File.separator + "test.txt" );    // 定义保存路径
		ObjectInputStream ois   = null;                         // 声明对象输入流
		InputStream       input = new FileInputStream( f );     // 文件输入流
		ois = new ObjectInputStream( input );                   // 实例化对象输入流
		Object obj = ois.readObject();                          // 读取对象
		ois.close();                                            // 关闭
		System.out.println( obj );
	}
}
