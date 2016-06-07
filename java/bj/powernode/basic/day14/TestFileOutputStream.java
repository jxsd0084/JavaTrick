package bj.powernode.basic.day14;

import java.io.*;

public class TestFileOutputStream {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		FileOutputStream fos = null;

		try {

			// 1.创建一个输出流(向文件中写入数据)

			// fos = new FileOutputStream("D:/course/JavaProjects/day14/tempFile");       // 将原来文件覆盖,如果源文件不存在则创建.

			fos = new FileOutputStream( "D:/course/JavaProjects/day14/tempFile", true );  // 追加方式

			// 2.开始写.
			fos.write( 97 );

			fos.write( 'b' );


			byte[] bytes = { 99, 100, 101, 102 };

			fos.write( bytes );
			
			
			
			/*
				byte[] bytes2 = {0,0,0,103,104,105,0,0};

				fos.write(bytes2,3,3);
			*/

			fos.flush();


		} catch ( FileNotFoundException e1 ) {
			e1.printStackTrace();

		} catch ( IOException e2 ) {
			e2.printStackTrace();

		} finally {
			try {
				if ( fos != null ) {

					fos.close();
				}
			} catch ( IOException e ) {

				e.printStackTrace();
			}

		}

	}

}
