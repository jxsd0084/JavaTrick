package bj.mldn.javase01.no69.copydemo;

import java.io.*;

public class Copy {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {   // 所有异常抛出
		if ( args.length != 2 ) { // 参数不是两个
			System.out.println( "操作的语法不正确，应该输入要拷贝的文件路径。" );
			System.out.println( "例：java Copy 源文件路径 目标文件路径" );
			System.exit( 1 ); // 系统退出
		}
		if ( args[ 0 ].equals( args[ 1 ] ) ) {
			System.out.println( "无法复制自身文件。" );
			System.exit( 1 ); // 系统退出
		}
		File file1 = new File( args[ 0 ] ); // 找到第一个文件的File对象
		if ( file1.exists() ) {
			File         file2  = new File( args[ 1 ] ); // 找到目标文件路径
			InputStream  input  = new FileInputStream( file1 );   // 输入流
			OutputStream output = new FileOutputStream( file2 );  // 输出流
			int          temp   = 0;                            // 定义一个整数表示接收的内容
			while ( ( temp = input.read() ) != - 1 ) {              // 表示还有内容可以继续读
				output.write( temp ); // 写入数据
			}
			System.out.println( "文件复制成功。" );
			input.close();          // 关闭
			output.close();         // 关闭
		} else {
			System.out.println( "源文件不存在。" );
		}
	}

}
