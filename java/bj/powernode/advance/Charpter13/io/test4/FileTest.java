package bj.powernode.advance.Charpter13.io.test4;

import java.io.*;

public class FileTest {

	public static void readFile() {

		FileReader fr = null;
		try {
			fr = new FileReader( "c:\\aa.txt" );

			int i = 0;
			while ( ( i = fr.read() ) != - 1 ) {
				System.out.print( (char) i );
			}

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
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
		}
	}

	public static void writeFile() {

		FileWriter fw = null;
		try {
			fw = new FileWriter( "data1.txt", true );

			String s = "boolean ready()：判断流是否已经准备好被读取\n";
			// char [] cbuf = s.toCharArray();
			// fw.write(cbuf);
			fw.write( s );
			System.out.println( "文件写入成功" );

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

	public static void readFile1() {

		FileReader     fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader( "c:\\aa.txt" );
			br = new BufferedReader( fr );

			String s = "";
			while ( ( s = br.readLine() ) != null ) {
				System.out.println( s );
			}
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
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
		}
	}

	public static void writeFile1() {

		FileWriter  fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter( "data1.txt", true );
			pw = new PrintWriter( fw );

			String s = "boolean ready()：判断流是否已经准备好被读取";
			pw.println( s );
			pw.println( s );
			pw.println( s );
			pw.println( s );

			System.out.println( "文件写入成功" );

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
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		readFile();

		writeFile();

		readFile1();

		writeFile1();

	}

}
