package bj.powernode.basic.day14;

import java.io.*;

public class TestFileInputStream2 {

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


			// 循环读取文件
			/*
				int temp = 0;
				while(true){

					temp = fis.read();

					if(temp==-1) break;

					System.out.print((char)temp);
				}
			*/

			int temp = 0;
			while ( ( temp = fis.read() ) != -1 ) {

				// System.out.print((char)temp); // 输出流

				PrintStream ps = System.out;     // 输出流

				ps.print( (char) temp );
			}

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
