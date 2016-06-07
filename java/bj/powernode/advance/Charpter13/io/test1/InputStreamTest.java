package bj.powernode.advance.Charpter13.io.test1;

import java.io.*;

public class InputStreamTest {

	/**
	 * 注意:此方法中读取数据的效率较低,需要高频繁的对文件进行读取,
	 * 后面包装成高级流BufferedInputStream,性能会得到明显改善.
	 */
	// 读取文件的方法
	public static void readFile() {

		// 用来读取字节流数据
		FileInputStream fin = null;

		try {
			// 根据路径打开一个文件 

			fin = new FileInputStream( "c:\\aa.txt" );

			//  设置局部变量并初始化
			int i = 0;

			//  while循环读取数据字节,注:read()是从父类InputStream中继承下来的方法
			while ( ( i = fin.read() ) != - 1 ) {

				//  注:read()返回的是int类型的数据,如果要打印输出的话,需要转换为char类型的数据
				System.out.print( (char) i );
			}
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// 如果对象存在的话
			if ( fin != null ) {
				try {

					// 要注意关闭流,此处的close()是从父类InputStream中继承下来的方法
					fin.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 向文件中写入字节数据的方法
	public static void writeFile() {

		// 向文件输出字节流的方法
		FileOutputStream fout = null;
		try {

			// 向"data.txt"文件中写入数据,true表示并在文件末尾追加而不是覆盖
			fout = new FileOutputStream( "data.txt", true );

			// 准备一个将要向文件中输入的字符串数据
			String s = "定义了很多用于处理输入流的方法,是个抽象类\n";

			// 通过String的getBytes方法将字符串编码为byte类型的数组
			byte[] b = s.getBytes();

			// 调用write方法将byte数组写入到文件中,此处的write是从父类OutputStream中继承下来 的,只能写入
			// byte数组或int类型的数据
			fout.write( b );
			System.out.println( "文件写入成功!" );

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {

			// 如果对象存在
			if ( fout != null ) {
				try {

					// 要注意将输出流给关闭掉
					fout.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//复制文件的方法
	public static void copyFile() {
		// 读取文件的流
		FileInputStream fin = null;

		// 写入文件的流
		FileOutputStream fout = null;

		try {
			//确定读取数据的文件路径
			fin = new FileInputStream( "c:\\aa.txt" );

			//准备好复制文件的输出路径,true表示追加而不是覆盖
			fout = new FileOutputStream( "E:\\course\\02-JavaSE\\课程\\Day9_2011.7.01_Chapter08_IO\\aa.txt", true );

			//准备int类型局部变量并初始化,估计下一步是要循环了
			int i = 0;

			//while循环,用read方法读取,!=-1表示还没有读到末尾,返回的是一个int类型的数据
			while ( ( i = fin.read() ) != - 1 ) {

				//将读出来的int类型数据再写入文件输出流,此处的write支持int类型的数据
				fout.write( i );
			}

			System.out.println( "文件拷贝成功!" );

		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			//如果输入流的对象存在
			if ( fin != null ) {
				try {

					//要注意将输入流给关闭
					fin.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			//如果输出流的对象存在
			if ( fout != null ) {
				try {

					//要注意把输出流给关闭
					fout.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

	}


	/**
	 * 注意:以下方法是带有缓冲的输入/输出流方法,主要思想是将低级流包装成高级流进行输出,提供效率.
	 * 关键字为:BufferedInputStream 和 BufferedOutputStream
	 *
	 * @param srcFile
	 * @param desFile
	 */

	//复制文件的方法2,此处传入了两个参数分别为String类型的源文件和目标文件
	public static void copyFile2( String srcFile, String desFile ) {
		// 低级的读取文件的流
		FileInputStream fin = null;

		// 低级的写入文件的流
		FileOutputStream fout = null;

		//高级的读取流
		BufferedInputStream bin = null;

		//高级输出流
		BufferedOutputStream bout = null;

		try {

			//创建低级输入流对象源文件的路径
			fin = new FileInputStream( srcFile );

			//将低级输入流包装成高级输出流
			bin = new BufferedInputStream( fin );

			//创建低级输入流对象目标文件的路径
			fout = new FileOutputStream( desFile );

			//将低级输出流包装成高级输出流
			bout = new BufferedOutputStream( fout );

			//准备好缓冲区容量10兆
			byte[] buff = new byte[ 1024 * 10 ];

			//创建int类型的局部变量,下一步循环
			int i = 0;

			//调用read方法读取数据,此处的buff是一个byte类型数组的引用,作为缓冲区容量传给read,!=-1表示底层流还没有读到末尾
			while ( ( i = bin.read( buff ) ) != - 1 ) {

				//此处的write包含变异量参数,i表示将从read中读取到的全部数据都写入到缓冲的输出流中
				bout.write( buff, 0, i );
			}

			//注意:使用缓冲流的时候还需要用flush方法将缓存中的剩余数据一次性全部输出
			bout.flush();

			System.out.println( "文件拷贝成功!" );

		} catch ( FileNotFoundException e ) {

			e.printStackTrace();
		} catch ( IOException e ) {

			e.printStackTrace();
		} finally {

			//如果低级输入流的对象存在
			if ( fin != null ) {
				try {

					//注意关闭低级输入流
					fin.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			//如果低级输出流的对象存在
			if ( fout != null ) {
				try {

					//注意关闭低级输出流
					fout.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * (静态方法)拷贝指定的文件到目标路径中
	 *
	 * @param srcFile 要拷贝的文件
	 * @param desPath 目标路径
	 */
	public static void copyFile3( File srcFile, String desPath ) {
		// 低级的读取文件的流
		FileInputStream fin = null;
		// 低级的写入文件的流
		FileOutputStream fout = null;

		//高级输入流
		BufferedInputStream bin = null;
		//高级输出流
		BufferedOutputStream bout = null;

		try {

			//将低级输入流包装成高级输入流
			fin = new FileInputStream( srcFile );
			bin = new BufferedInputStream( fin );

			// 取得文件名, String getName() 返回由此抽象路径名表示的文件或目录的名称。 
			String fileName = srcFile.getName();

			// static String separator 与系统有关的默认名称分隔符 
			String desFileAndPath = desPath + File.separator + fileName;

			//将低级输出流包装成高级输出流
			fout = new FileOutputStream( desFileAndPath );
			bout = new BufferedOutputStream( fout );

			//準備緩存空間
			byte[] buff = new byte[ 1024 * 10 ];
			//創建區域變量準備循環讀取
			int i = 0;

			//循環讀取
			while ( ( i = bin.read( buff ) ) != - 1 ) {
				//寫入數據
				bout.write( buff, 0, i );
			}

			//將緩存區剩餘數據全部輸出
			bout.flush();

			System.out.println( "文件拷贝成功!" );

		} catch ( FileNotFoundException e ) {

			e.printStackTrace();
		} catch ( IOException e ) {

			e.printStackTrace();
		} finally {

			//如果低級輸入流的對象存在
			if ( fin != null ) {
				try {

					//注意關閉低級輸入流
					fin.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}

			//如果低級輸出流的對象存在
			if ( fout != null ) {
				try {

					//注意關閉低級輸出流
					fout.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	//主方法測試
	public static void main( String[] args ) {
		// readFile();
		// writeFile();

		//创建File对象并将源文件路径传入
		// File srcFile = new File("G:\\常用工具\\PowerWordPE_F.33715.0.zip");
		//创建目标文件路径
		// String desPath ="E:\\course\\02-JavaSE\\课程\\Day9_2011.7.01_Chapter08_IO";
		//调用copyFile3静态方法并将源文件和目标文件的路径传入
		// copyFile3(srcFile, desPath);
	}
}
