package bj.powernode.advance.Charpter13.io.test6;

import java.io.*;

public class AppendFile {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		wirte();

		read();
	}

	public static void read() {

		try {
			int    i      = 0;
			String record = new String();
			String toCn   = null;

			RandomAccessFile rf2   = new RandomAccessFile( "toAppend.txt", "r" );
			String           outCn = null;
			while ( ( record = rf2.readLine() ) != null ) {
				i++;
				// 处理中文问题
				// outCn = record; // 没有处理编码的格式
				outCn = new String( record.getBytes( "ISO8859_1" ), "GBK" );

				System.out.println( "Line " + i + ":" + outCn );
			}
			rf2.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void wirte() {

		String toAppend = "将发了三分家法律的思";
		try {
			int    i      = 0;
			String record = new String();
			String toCn   = null;

			// 处理中文问题
			toCn = new String( toAppend.getBytes( "GBK" ), "ISO8859_1" );

			RandomAccessFile rf1 = new RandomAccessFile( "toAppend.txt", "rw" );
			rf1.seek( rf1.length() );
			rf1.writeBytes( toCn + "\n" );
			rf1.close();

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
