package bj.powernode.advance.Charpter13.io.test2;

import java.io.*;

public class FileTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		File file = new File( "C:\\JDK1.6\\src" );
		fun1( file );

		String file2   = "C:\\JDK1.6\\src";
		int    icount = 0;
		icount = fileTest( file2, icount );

		System.out.println( "文件中个数:" + icount );

		fun2();
	}

	public static void fun2() {

		File f = new File( "c:\\aaaa\\bbb\\ccc\\ddd\\eee" );
		System.out.println( f.mkdirs() );
	}

	public static void fun1( File file ) {

		if ( file.isDirectory() ) {
			File[] files = file.listFiles();
			for ( File f : files ) {
				if ( f.isFile() ) {
					System.out.println( f + "=============是一个文件" );
				} else {
					fun1( f );
				}
			}
		} else {
			System.out.println( file + "=============是一个文件" );
		}
	}

	/**
	 * 递归统计指定路径中文件的个数
	 *
	 * @param pathName 路径的名称
	 * @param iCount   文件的个数
	 * @return 文件的总个数
	 */
	public static int fileTest( String pathName, int iCount ) {

		File file = new File( pathName );
		if ( file.isDirectory() ) {
			System.err.println( pathName + "==============是一个路径" );
			File[] files = file.listFiles();
			if ( files != null ) {
				for ( File f : files ) {
					if ( f.isDirectory() ) {
						String path = f.getAbsolutePath();
						iCount = fileTest( path, iCount );
					} else {
						if ( f.getName().endsWith( ".java" ) ) {
							iCount++;
						}
					}
				}
			}
		} else {
			System.out.println( "=================" + pathName + "是一个文件" );
		}

		return iCount;
	}

}
