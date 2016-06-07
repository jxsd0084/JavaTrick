package bj.mldn.javase02.ch12.no01;

import java.io.File;

public class FileDemo11 {

	private static final String SPLIT_TAG = "MR\\";

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

//		File my = new File( "d:" + File.separator );    // 操作路径
		File my = new File( "E:\\Knowledge\\Java\\JavaCodes\\out_utf-8\\out_utf-8代码\\MR" );    // 操作路径

		print( my );

	}

	public static void print( File file ) {             // 递归调用

		if ( file != null ) {                           // 判断对象是否为空

			if ( file.isDirectory() ) {                 // 如果是目录

				File[] f = file.listFiles();            // 列出全部的文件

				if ( f != null ) {                      // 判断此目录能否列出

					for ( int i = 0; i < f.length; i++ ) {

						print( f[ i ] );                // 因为给的路径有可能是目录，所以，继续判断
					}
				}

			} else {
				if ( file.toString().endsWith( ".java" ) ) {

					String filename = file.getName();
					String path     = file.getParent();
					int    pos      = path.indexOf( SPLIT_TAG ) + SPLIT_TAG.length();

					System.out.println( path.substring( 0, pos + 3 ) );

					if ( file.renameTo( new File( path.substring( 0, pos + 3 ) + filename ) ) ) {
						System.out.println( "OK!" );

					} else {
						System.out.println( "Not OK!" );

					}

//					file.renameTo( new File( file.getParent() ) );
//					System.out.println( file.getAbsolutePath() );                       // 输出路径
//					System.out.println( path.substring( 0, path.indexOf( "MR" ) ) );    // 输出路径
//					System.out.println( path.substring( path.indexOf( "MR" ), 56 ) );   // MR\598
//					System.out.println( path.substring( pos, pos + 3 ) );               // MR\598
//					System.out.println( path.substring( 0, pos + 3 ) );                 // E:\Knowledge\Java\JavaCodes\out_utf-8\out_utf-8代码\MR\598

				}

			}

		}

	}

}
