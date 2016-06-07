package bj.powernode.advance.Charpter14.homework;

import java.io.*;

public class FileCopy {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		copySrc( "C:\\JDK1.6\\src", "E:\\" );
	}

	public static void copySrc( String srcPath, String desPath ) {

		File file = new File( srcPath );

		if ( file.isDirectory() ) {
			String fileName = file.getName();
			String ename    = desPath + File.separator + fileName;
			File   fn       = new File( ename );
			fn.mkdirs();

			File[] files = file.listFiles();
			if ( files != null ) {
				for ( File f : files ) {
					String path = f.getAbsolutePath();

					copySrc( path, ename );
				}
			}
		} else {
			File srcFile = new File( srcPath );
			copyFile( srcFile, desPath );
		}
	}

	public static void copyFile( File scrFile, String despath ) {

		FileInputStream  fin  = null;
		FileOutputStream fout = null;
		try {
			fin = new FileInputStream( scrFile );
			String fName = scrFile.getName();
			String eFile = despath + File.separator + fName;
			fout = new FileOutputStream( eFile );
			BufferedInputStream  bin    = new BufferedInputStream( fin );
			BufferedOutputStream bout   = new BufferedOutputStream( fout );
			byte                 buff[] = new byte[ 1024 ];
			int                  i      = 0;
			try {
				while ( ( i = bin.read( buff ) ) != - 1 ) {
					bout.write( buff, 0, i );
				}
				bout.flush();
				System.out.println( scrFile + "已经copy完成" + "存放在" + despath );
			} catch ( IOException e ) {

				e.printStackTrace();
			}
		} catch ( FileNotFoundException e ) {

			e.printStackTrace();
		} finally {
			if ( fin != null ) {
				try {
					fin.close();
				} catch ( IOException e ) {

					e.printStackTrace();
				}

			}
			if ( fout != null ) {
				try {
					fout.close();
				} catch ( IOException e ) {

					e.printStackTrace();
				}
			}

		}

	}
}
