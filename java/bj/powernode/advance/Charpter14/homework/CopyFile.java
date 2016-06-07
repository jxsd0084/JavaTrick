package bj.powernode.advance.Charpter14.homework;

import java.io.*;

/*
 * 1.递归拷贝C:\JDK1.5\src下面所有的文件
 */
public class CopyFile {

	/**
	 * 遍历目录的方法
	 *
	 * @param srcfile 源文件(是个文件夹)
	 * @param desPath 目标目录
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void bianLiMuLu( File srcfile, String desPath )
			throws FileNotFoundException, IOException {
		// 判断srcfile是否是个目录
		if ( srcfile.isDirectory() ) {
			// 根据源文件的目录,创建目标文件的路径 路径个格式是C:\\JDK1.5\\src
			String srcPath = srcfile.getPath();
			String ss      = getSrcPath( srcPath );

			// 创建目标文件的路径 名称 格式:d:\\src
			String desRealPath = desPath + File.separator + ss;
			File   f           = new File( desRealPath );
			f.mkdirs();

			// 遍历源文件夹
			File[] files = srcfile.listFiles();
			for ( File file : files ) {
				if ( file.isFile() ) {
					copyFile( file, desRealPath );
				} else {
					bianLiMuLu( file, desRealPath );
				}
			}
		}
		// 如果是一个文件,则直接拷贝该文件
		else {
			copyFile( srcfile, desPath );
		}

	}

	private static String getSrcPath( String srcPath ) {

		String[] strs = srcPath.split( "\\" );
		String   ss   = strs[ strs.length - 1 ];
		return ss;
	}

	/**
	 * 拷贝文件的方法
	 *
	 * @param srcfile 源文件,是个文件(不是路径)
	 * @param desPath 目标文件的路径
	 * @throws IOException ,FileNotFoundException
	 */
	private static void copyFile( File srcfile, String desPath )
			throws IOException, FileNotFoundException {

		// 声明一个文件读取流，从节点流中读取数据
		FileInputStream fin = null;
		// 声明一个文件输出流，将别村中的信息写入到文件中
		FileOutputStream fout = null;

		BufferedInputStream  bin  = null;
		BufferedOutputStream bout = null;

		try {
			// 准备输入流
			fin = new FileInputStream( srcfile );
			bin = new BufferedInputStream( fin );

			// 准备目标文件的路径和文件名
			String fileName           = srcfile.getName();
			String desFilePathAndName = desPath + "\\" + fileName;

			// 准备输出流
			fout = new FileOutputStream( desFilePathAndName );
			bout = new BufferedOutputStream( fout );

			byte[] buff = new byte[ 1024 * 8 ];
			int    i    = 0;

			while ( ( i = bin.read( buff ) ) != - 1 ) {
				bout.write( buff, 0, i );
			}

			bout.flush();

		} finally {
			if ( fin != null ) {
				fin.close();
			}

			if ( fout != null ) {
				fout.close();
			}
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		File   file    = new File( "C:\\JDK1.6\\src" );
		String desPath = "e:\\";
		try {
			bianLiMuLu( file, desPath );
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
