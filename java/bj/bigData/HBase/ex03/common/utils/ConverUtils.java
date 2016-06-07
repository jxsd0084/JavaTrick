package bj.bigData.HBase.ex03.common.utils;

public class ConverUtils {

	public static int stringToInt( String s ) {

		int i = -1;
		if ( s != null ) {
			try {
				i = Integer.parseInt( s );
			} catch ( Exception e ) {
			}
		}
		return i;
	}

	public static long stringToLong( String s ) {

		long i = -1;
		if ( s != null ) {
			try {
				i = Long.parseLong( s );
			} catch ( Exception e ) {
			}
		}
		return i;
	}


}
