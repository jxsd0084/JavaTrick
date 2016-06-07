package bj.powernode.basic.day14;

import java.io.*;

public class CopyFile3 {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( "D:/course/JavaProjects/day14/day14.txt" ) ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( "D:/course/JavaProjects/day14/day14.txt.bak" ) ) );


		String temp = "";
		while ( ( temp = br.readLine() ) != null ) {

			bw.write( temp + "\n" );
		}

		bw.flush();

		br.close();
		bw.close();

	}

}
