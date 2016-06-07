package bj.powernode.basic.day09;

import java.io.File;

/*

	java.io.File
		文件或者目录路径名的抽象表示形式.
	
		不能代表硬盘上的一个文件,不能通过该类完成文件的读写.
	
	java.io.File 由两部分组成: 路径分隔符 + 路径名
	
	注意：不同的操作系统有不同的路径分隔符.

		例如: windows    \
		     UNIX/Linux  /
*/
public class TestFile {


	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 输出操作系统中的路径分隔符.
		System.out.println( File.separator );  // 根据底层不同的操作系统获取不同形式的路径分隔符.

		String s = File.separator;

		// 1.构造方法
		File file1 = new File( "D:\\course\\JavaProjects\\day09" ); // 只适合windows


		// 通用的.
		File file2 = new File( "D:" + s + "course" + s + "JavaProjects" + s + "day09" );


		// 更加的通用的.
		File file3 = new File( "D:/course/JavaProjects/day09" );    // 适合windows+unix









		// 2.常用方法

		// 2.1 判断该抽象表示的是一个路径还是一个文件.
		boolean isFile = file3.isFile();
		boolean isDir  = file3.isDirectory();

		System.out.println( isFile ); //false
		System.out.println( isDir ); //true

		// 2.2 判断文件是否是可执行文件.
		// 判断文件是否可以读
		// 判断文件是否可以写
		File file4 = new File( "C:/jdk6/bin/javac.exe" );

		if ( file4.isFile() ) { //如果是一个文件

			// 判断文件是否是一个可执行文件.
			boolean isCanExe = file4.canExecute();
			System.out.println( isCanExe );

			boolean isCanRead = file4.canRead();
			System.out.println( isCanRead );

			boolean isCanWrite = file4.canWrite();
			System.out.println( isCanWrite );
		}


		// 2.3 如果文件不存在，则创建.
		File file5 = new File( "c:/hello.txt" );  //文件

		boolean isSuccess = file5.createNewFile();

		System.out.println( isSuccess );



		// 2.4 删除文件或者目录(目录要求必须为空)
		File    file6    = new File( "c:/hello1/hello2" );
		boolean isDelete = file6.delete();
		System.out.println( isDelete );

		file5.delete();



		// 2.5 判断文件或目录是否存在
		System.out.println( new File( "c:/test" ).exists() ? "存在" : "不存在" );


		//常用方法还包括:
		//       getAbsoluteFile
		//		 getAbsolutePath
		//		 getName
		//		 getParent
		//		 getParentFile
		//		 getPath
		//		 isAbsolute
		//		 isHidden
		//		 lastModified
		//		 length
		//		 list
		//		 listFiles
		//		 mkdir
		//		 mkdirs


		// 测试方法 listFiles
		File f = new File( "D:/course" );

		if ( f.isDirectory() ) {

			File[] files = f.listFiles();

			System.out.println( f.getAbsolutePath() + "路径下有" + files.length + "个文件或目录" );

			for ( int i = 0; i < files.length; i++ ) {

				File tempF = files[ i ];

				// System.out.println("\t" + tempF.getName());

				System.out.println( "\t" + tempF.getAbsolutePath() );
			}

		}

	}

}
