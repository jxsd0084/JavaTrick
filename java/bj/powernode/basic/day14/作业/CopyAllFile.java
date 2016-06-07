package bj.powernode.basic.day14.作业;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyAllFile {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		CopyAllFile.listFiles( "D:\\course\\JavaProjects" );

	}

	public static void listFiles( String pathname ) throws Exception {

		File file = new File( pathname );

		if ( file.isDirectory() ) {

			File[] subFiles = file.listFiles();

			for ( int i = 0; i < subFiles.length; i++ ) {

				File subFile = subFiles[ i ];

				String subFileAbsolutePath = subFile.getAbsolutePath();

				if ( subFile.isDirectory() ) {

					File destSubFile = new File( changePath( subFileAbsolutePath ) );

					if ( !destSubFile.exists() ) {

						destSubFile.mkdirs();
					}

				} else {

					FileInputStream  fis = new FileInputStream( subFileAbsolutePath );
					FileOutputStream fos = new FileOutputStream( changePath( subFileAbsolutePath ) );

					int    temp  = 0;
					byte[] bytes = new byte[ 1024 ];
					while ( ( temp = fis.read( bytes ) ) != -1 ) {

						fos.write( bytes, 0, temp );
					}

					fos.flush();
					fis.close();
					fos.close();

				}

				listFiles( subFileAbsolutePath );


			}

		}

	}

	public static String changePath( String path ) {

		return "E" + path.substring( 1 );
	}


}
