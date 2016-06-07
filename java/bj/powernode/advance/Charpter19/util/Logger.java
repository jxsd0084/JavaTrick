package bj.powernode.advance.Charpter19.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {

	private static String fileName = "c:\\log.txt";

	public static void printException( Throwable t ) {

		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream( fileName, true );
			PrintStream ps = new PrintStream( fout );

			String dateInfo = getDateInfo();
			ps.println( dateInfo );

			t.printStackTrace( ps );

		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} finally {
			if ( fout != null ) {
				try {
					fout.close();
				} catch ( IOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static String getDateInfo() {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS" );
		return format.format( date );
	}
}
