package bj.mldn.javase02.ch12.no17;

import java.io.*;

public class SerDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		ser();
		dser();
	}

	public static void ser() throws Exception {

		File               f   = new File( "D:" + File.separator + "test.txt" );    // 定义保存路径
		ObjectOutputStream oos = null;    // 声明对象输出流
		OutputStream       out = new FileOutputStream( f );    // 文件输出流
		oos = new ObjectOutputStream( out );
		oos.writeObject( new Person( "张三", 30 ) );    // 保存对象
		oos.close();    // 关闭
	}

	public static void dser() throws Exception {

		File              f     = new File( "D:" + File.separator + "test.txt" );    // 定义保存路径
		ObjectInputStream ois   = null;    // 声明对象输入流
		InputStream       input = new FileInputStream( f );    // 文件输入流
		ois = new ObjectInputStream( input );    // 实例化对象输入流
		Object obj = ois.readObject();    // 读取对象
		ois.close();    // 关闭
		System.out.println( obj );
	}
}
