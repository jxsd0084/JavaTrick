package bj.powernode.basic.day14;

import java.io.*;


/*

	将D:\course\JavaProjects\day14\FirstFile 复制 D:\course\JavaProjects\day14\FirstFile.bak

	输入流 + 输出流

*/
public class CopyFile {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		FileInputStream  fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream( "D:\\course\\JavaProjects\\day14\\FirstFile" );
			fos = new FileOutputStream( "D:\\course\\JavaProjects\\day14\\FirstFile.bak" );
			
			/*
				int temp = 0;
				while((temp=fis.read())!=-1){

					fos.write(temp);
				}
			*/

			byte[] temps = new byte[ 1024 ]; //1KB
			int    temp  = 0;
			while ( ( temp = fis.read( temps ) ) != -1 ) {

				//fos.write(temps);
				fos.write( temps, 0, temp );
			}

		} catch ( Exception e ) {

			e.printStackTrace();
		} finally {
			try {
				if ( fis != null ) {

					fis.close();
				}

			} catch ( Exception e ) {

				e.printStackTrace();
			}

			try {
				if ( fos != null ) {

					fos.close();
				}
			} catch ( Exception e ) {

				e.printStackTrace();
			}

		}


		//.......

	}
}
