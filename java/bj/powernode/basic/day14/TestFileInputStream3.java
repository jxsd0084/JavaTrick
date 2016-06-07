package bj.powernode.basic.day14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream3 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		FileInputStream fis = null;

		try {

			// 创建一个文件输入流对象.(读取硬盘上的某个文件)
			// fis = new FileInputStream("D:\\course\\JavaProjects\\day14\\FirstFile");
			// fis = new FileInputStream("D:/course/JavaProjects/day14/FirstFile");

			String separator = File.separator;
			fis = new FileInputStream( "D:" + separator + "course" + separator + "JavaProjects" + separator + "day14" + separator + "FirstFile" );

			System.out.println( fis.available() ); // 流中的估计字节数

			// 读到byte数组中.
			byte[] bytes = new byte[ 3 ];

			int temp = 0;
			while ( ( temp = fis.read( bytes ) ) != -1 ) {

				System.out.print( new String( bytes, 0, temp ) );
			}


			// 知道字节数之后.
			// 适合超小文件.
			/*
				byte[] bytes = new byte[fis.available()];

				fis.read(bytes);

				System.out.println(new String(bytes));
			*/


		} catch ( FileNotFoundException e ) {

			// 打印异常堆栈,便于调试程序.
			e.printStackTrace();


			// 输出信息
			System.out.println( "文件未找到." );

			// 程序非正常结束.
			System.exit( -1 );


		} catch ( IOException e1 ) {

			e1.printStackTrace();

		} finally {

			try {
				// 关闭流
				if ( fis != null ) {

					fis.close();
				}
			} catch ( IOException e ) {

				e.printStackTrace();

				System.out.println( "关闭流失败" );

				System.exit( -1 );
			}


		}


	}

}
