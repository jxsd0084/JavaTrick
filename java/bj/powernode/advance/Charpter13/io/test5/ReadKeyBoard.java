package bj.powernode.advance.Charpter13.io.test5;

import java.io.*;

public class ReadKeyBoard {

	public static void readKeyBoard() {

		BufferedReader br = null;
		br = new BufferedReader( new InputStreamReader( System.in ) );

		String s = "";
		try {
			while ( ( s = br.readLine() ) != null && s.length() > 0 ) {
				if ( "exit".equalsIgnoreCase( s ) ) {
					break;
				}

				System.out.println( "从键盘读取的数据:" + s );
			}
		} catch ( IOException ex ) {
			ex.printStackTrace();
		}
	}

	/**
	 * 读取键盘的数据,并且保存到文件中
	 */
	public static void readKeyBoardToFile() {
		// 用来读取键盘数据的流
		InputStream    in = System.in;
		BufferedReader br = null;

		// 用来保存String到文件的流
		FileWriter  fw = null;
		PrintWriter pw = null;

		// 初始化写String到文件的流
		try {
			// 初始化读取键盘数据的高级流
			br = new BufferedReader( new InputStreamReader( in ) );

			// 初始化保存String到文件的流
			fw = new FileWriter( "data.txt" );
			pw = new PrintWriter( fw );

			System.out.println( "请从键盘输入数据:" );
			String s = null;
			while ( ( s = br.readLine() ) != null ) {

				if ( s.length() == 0 ) {
					continue;
				}

				if ( "saved".equalsIgnoreCase( s ) ) {
					break;
				}
				pw.println( s );
			}

			System.out.println( "文件已经保存成功!" );
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( fw != null ) {
				try {
					fw.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 使用字符流在实现文本文件的拷贝
	 *
	 * @param srcFile 源文件
	 * @param desPath 目标路径
	 */
	public static void copy( File srcFile, String desPath ) {
		// 读取文件的字符流
		FileReader     fr = null;
		BufferedReader br = null;

		// 写入文件的流
		FileWriter  fw = null;
		PrintWriter pw = null;

		try {
			// 初始化读取文件的字符流
			fr = new FileReader( srcFile );
			br = new BufferedReader( fr );

			// 确定目标文件的路径和名称
			String desFile = desPath + File.separator + srcFile.getName();

			fw = new FileWriter( desFile );
			pw = new PrintWriter( fw );

			String s = null;
			while ( ( s = br.readLine() ) != null ) {
				pw.println( s );
			}

			System.out.println( "文件拷贝成功!" );

		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( fr != null ) {
				try {
					fr.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if ( fw != null ) {
				try {
					fw.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void readRile() {

		char[]          arrays = { 'a', '你', '好', '啊', 't' };
		CharArrayReader reader = new CharArrayReader( arrays );
		int             i      = 0;
		try {
			while ( ( i = reader.read() ) != - 1 ) {
				System.out.print( (char) i );
			}
		} catch ( IOException e ) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		reader.close();
	}

	public static void readRile1() {

		String       str    = "经费来的快速家法律监督是分机离开收到\n将发了开赛发了看见的说\n发觉脸上开发介绍两分巨大胜利\n";
		StringReader reader = new StringReader( str );
		int          i      = 0;
		try {
			while ( ( i = reader.read() ) != - 1 ) {
				System.out.print( (char) i );
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		reader.close();
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		File   srcFile = new File( "c:\\aa.txt" );
		String desPath = "E:\\course\\02-JavaSE\\课程\\Day9_2011.7.01_Chapter08_IO";

		copy( srcFile, desPath );

		readRile1();
	}

}
