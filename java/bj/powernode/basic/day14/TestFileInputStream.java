package bj.powernode.basic.day14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

	/**
	 * 测试
	 *
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

			// 开始读取文件.
			int first = fis.read();

			System.out.println( first );

			System.out.println( (char) first );     // p

			int second = fis.read();                // 继续读

			System.out.println( second );

			System.out.println( (char) second );

			int third = fis.read();                 // 继续读

			System.out.println( third );            // -1

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
