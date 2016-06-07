package bj.powernode.advance.Charpter13.io.test2;

import java.io.*;

public class CopyFileTest {

	// 拷贝整个文件夹的copyFiles方法
	public void copyFiles( String path1, String path2 ) throws Exception {
		// TODO Auto-generated method stub
		File file = new File( path1 );
		// 判断是否是一个路径,如果是,将路径下面的子文件夹列出来放在一个File类型的数组中
		if ( file.isDirectory() ) {

			File f = new File( path2 );

			if ( ! f.exists() ) {
				f.mkdir();
			}
			File[] files = file.listFiles();
			// 循环遍历File数组并且复制文件
			for ( File file2 : files ) {
				// System.out.println(file2.toString()+"-----"+path2+"/"+file2.getName());
				copyFiles( file2.toString(), path2 + "/" + file2.getName() );
			}
		} else {
			copy( path1, path2 );
		}
	}

	// 拷贝单个文件的方法
	public void copy( String path1, String path2 ) throws IOException {

		// TODO Auto-generated method stub
		DataInputStream in = new DataInputStream( new BufferedInputStream( new FileInputStream( path1 ) ) );

		byte[] date = new byte[ in.available() ];
		in.read( date );

		DataOutputStream out = new DataOutputStream( new BufferedOutputStream( new FileOutputStream( path2 ) ) );

		out.write( date );
		in.close();
		out.close();
	}


	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		CopyFileTest dp = new CopyFileTest();
		// dp.deleteFile("c:\\xxxx");
		dp.copyFiles( "D:\\Program Files\\Java\\jdk1.6.0_23\\src", "c:\\TestJava" );
	}
}




